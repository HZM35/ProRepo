package com.example.sprint2.Services.SensorDataConfig;

import com.example.sprint2.Entities.Sensor;
import com.example.sprint2.Entities.SensorData;
import com.example.sprint2.Pojos.SensorPojo;
import com.example.sprint2.Repositories.SensorDataRepository;
import com.example.sprint2.Repositories.SensorReposistory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

@Configuration
public class SensorDataConfig {




//    	@Bean
//	CommandLineRunner commandLineRunner( SensorDataRepository repository) {
//		return args ->{
////			SensorDataService service = new SensorDataService(repository);
////			Sensor sensor1 = new Sensor("eui-24e124136b326424");
////			List<SensorData> dataBySensorName = service.getSensorDataOneSensor(sensor1);
////			System.out.println(dataBySensorName);
//
//			DateTimeFormatter  sdf =  DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS'Z'");
//			String date = "2022-06-19T00:36:17.323443123Z";
////			sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
//			System.out.println(sdf.parse(date) );
//		};
//
//	}





//    @Bean
//    CommandLineRunner commandLineRunner(SensorDataRepository repository, SensorReposistory sensorrepository){
//
//        return args -> {
//
//
//            String authorizationHeader = "Bearer NNSXS.ZRXFR2SOKJ4TV6JZE25ZDCVHGP73G3UO6JQZCGQ.4L3QRDHULYWU7F7SOO2HVBAJXBPAR6WGIZLHQW6PHE7JZN2HCCWA";
//
//
//            // Create HTTP Client
//            HttpClient client = HttpClient.newHttpClient();
//
//
//            // Create HTTP request object
//            HttpRequest request = HttpRequest.newBuilder().GET().header("Accept", "application/json").header("Authorization", authorizationHeader)
//                    .uri(URI.create("https://eu1.cloud.thethings.network/api/v3/as" +
//                            "/applications" +
//                            "/cdiweathernet" +
//                            "/packages" +
//                            "/storage" +
//                            "/uplink_message"))
//
//
//                    .build();
//            HttpResponse<String> response = null;
//
//            try {
//                response = client.send(request,
//                        HttpResponse.BodyHandlers.ofString());
//                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//                System.out.println("[ " + response+ " ]");
//                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
////
//////		                InputStream in = request.getInputStream();
////
//                BufferedWriter writer = new BufferedWriter(new FileWriter("output3.txt"));
//                writer.write(response.body());
//                writer.close();
//////		        System.out.println(" has been complete");
//                BufferedReader reader = new BufferedReader(new FileReader("output3.txt") );
//                ObjectMapper objectMapper = new ObjectMapper();
//                ArrayList<SensorPojo> myList = new ArrayList<SensorPojo>();
//                String line;
//                while((line = reader.readLine()) !=null  ){
//                    if(line.contains("decoded_payload") ){
//                        SensorPojo infos = objectMapper.readValue(line, SensorPojo.class);
//                        myList.add( infos);
//////		                System.out.println(line.length());
//                    }else{
//////		                System.out.println("MetaDATA");
//                    }
////
//                }
//                ArrayList<Sensor> sensors = new ArrayList<Sensor>();
//                ArrayList <SensorData> sensorDynmicData = new ArrayList<>();
//                for (SensorPojo sensorPojo: myList) {
//                    Sensor sensor = new Sensor();
//                    SensorData sensorData = new SensorData();
//                    sensor.setDeviceId(sensorPojo.getResult().getEndDeviceIds().getDeviceId());
//                    if(sensorPojo.getResult().getUplinkMessage().getLocations() != null) {
//                        sensor.setLattitiude(sensorPojo.getResult().getUplinkMessage().getLocations().getUser().getLatitude());
//                        sensor.setLongitude(sensorPojo.getResult().getUplinkMessage().getLocations().getUser().getLongitude());
//                    }
//                    sensorData.setTemperature(sensorPojo.getResult().getUplinkMessage().getDecodedPayload().getTemperature());
//                    sensorData.setHumidity(sensorPojo.getResult().getUplinkMessage().getDecodedPayload().getHumidity());
//                    sensorData.setRecievedAt(sensorPojo.getResult().getUplinkMessage().getReceivedAt());
//                    sensorDynmicData.add(sensorData);
//                    sensors.add(sensor);
////
//                    if(!sensors.contains(sensor.getDeviceId())) {
//                        sensorrepository.save(sensor);
//                    }
////
//                    sensorData.setSensor(sensor);
////
//////		             Optional<SensorData> dataById = repository.findByRecieved_atAndSensor(sensorData.getRecievedAt(), sensorData.getSensor());
////
////
//                    repository.save(sensorData);
////
////
////
////
//                }
////
//                System.out.println(myList.size());
//                reader.close();
//            }catch(FileNotFoundException e){
//                System.out.println("the file not hier");
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
////
//
//        };
////
//
//    }
}
