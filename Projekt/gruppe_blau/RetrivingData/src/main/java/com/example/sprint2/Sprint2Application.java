package com.example.sprint2;

import com.example.sprint2.Entities.Sensor;
import com.example.sprint2.Entities.SensorData;
import com.example.sprint2.Pojos.SensorPojo;
import com.example.sprint2.Repositories.SensorDataRepository;
import com.example.sprint2.Repositories.SensorReposistory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

@SpringBootApplication
@EnableScheduling
public class Sprint2Application {
    @Autowired
    private SensorDataRepository senorDataRepsitory;

    @Autowired
    private SensorReposistory reposistory;

    public static void main(String[] args) {
        SpringApplication.run(Sprint2Application.class, args);
    }


    @Scheduled(fixedDelay = 300000L)
    public void retrieve() {
        String authorizationHeader = "Bearer NNSXS.ZRXFR2SOKJ4TV6JZE25ZDCVHGP73G3UO6JQZCGQ.4L3QRDHULYWU7F7SOO2HVBAJXBPAR6WGIZLHQW6PHE7JZN2HCCWA";


        // Create HTTP Client
        HttpClient client = HttpClient.newHttpClient();


        // Create HTTP request object
        HttpRequest request = HttpRequest.newBuilder().GET().header("Accept", "application/json").header("Authorization", authorizationHeader)
                .uri(URI.create("https://eu1.cloud.thethings.network/api/v3/as" + "/applications" + "/cdiweathernet" + "/packages" + "/storage" + "/uplink_message"))
                .build();
        HttpResponse<String> response = null;

        try {

            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("[ " + response + " ]");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

            BufferedWriter writer = new BufferedWriter(new FileWriter("output3.txt"));
            writer.write(response.body());
            writer.close();

            BufferedReader reader = new BufferedReader(new FileReader("output3.txt"));
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayList<SensorPojo> myList = new ArrayList<>();
            String line;
            int counterMetadata = 0;
            while ((line = reader.readLine()) != null) {
                if (line.contains("decoded_payload")) {
                    SensorPojo infos = objectMapper.readValue(line, SensorPojo.class);
                    myList.add(infos);

                } else {
                    counterMetadata++;
                }

            }

            ArrayList<Sensor> sensors = new ArrayList<>();
            ArrayList<SensorData> sensorDynmicData = new ArrayList<>();

            for (SensorPojo sensorPojo : myList) {
                Sensor sensor = new Sensor();
                SensorData sensorData = new SensorData();
                sensor.setDeviceId(sensorPojo.getResult().getEndDeviceIds().getDeviceId());

                if (sensorPojo.getResult().getUplinkMessage().getLocations() != null) {
                    sensor.setLattitiude(sensorPojo.getResult().getUplinkMessage().getLocations().getUser().getLatitude());
                    sensor.setLongitude(sensorPojo.getResult().getUplinkMessage().getLocations().getUser().getLongitude());
                }
                sensorData.setTemperature(sensorPojo.getResult().getUplinkMessage().getDecodedPayload().getTemperature());
                sensorData.setHumidity(sensorPojo.getResult().getUplinkMessage().getDecodedPayload().getHumidity());
                sensorData.setRecievedAt(sensorPojo.getResult().getUplinkMessage().getReceivedAt());
                sensorDynmicData.add(sensorData);
                sensors.add(sensor);

                if (!sensors.contains(sensor.getDeviceId())) {
                    reposistory.save(sensor);
                }

                sensorData.setSensor(sensor);
                senorDataRepsitory.save(sensorData);
            }

            int numberOfMessages = counterMetadata + myList.size();
            System.out.println("there is  " + numberOfMessages + " messages " + counterMetadata + " of them are metadata messages and " + myList.size() + " are payloaded messages");
            System.out.println("number of payloaded  messages is = " + myList.size());
            System.out.println("number of metadata messages is   = " + counterMetadata);
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("the file not hier");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
