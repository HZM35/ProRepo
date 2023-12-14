package com.example.sprint2;

import com.example.sprint2.Entities.Sensor;
import com.example.sprint2.Entities.SensorData;
import com.example.sprint2.Repositories.SensorDataRepository;
import com.example.sprint2.Repositories.SensorReposistory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.List;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Sprint2ApplicationTests {

    @LocalServerPort
    private int port;
    @Autowired
    private static RestTemplate restTemplate;
//    @Autowired
//    private TestH2Repository h2Repository;

    @Autowired
    SensorDataRepository sensorDataRepository;
    @Autowired
    SensorReposistory sensorReposistory;


    @BeforeAll
    public static void init (){
        restTemplate = new RestTemplate();
    }
    @BeforeEach
    public void setUp(){

    }






    @Test
    void testGetAllId() throws Exception {

        String baseUrl = "http://localhost";

        baseUrl = baseUrl.concat(":").concat(port + "").concat("/allSensors");


        Sensor sensor = new Sensor("24E124136B326431");

        sensorReposistory.save(sensor);

        List <String> response = restTemplate.getForObject(baseUrl, List.class);
        String actualSensor = response.get(0);
        assertThat(response.size()).isEqualTo(1);
        assertThat(actualSensor).isEqualTo(sensor.getDeviceId());
        System.out.println(response);
    }

    @Test
    void getAllLastUpdate() throws Exception {

        String baseUrl = "http://localhost";

        baseUrl = baseUrl.concat(":").concat(port + "").concat("/api/v1/lastUpdate");

        Sensor sensor = new Sensor("24E124136B326431");
        sensorReposistory.save(sensor);
        LocalDateTime dateTime = Instant.parse("2022-10-28T12:22:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        SensorData sensorData = new SensorData(17.5, 20, dateTime, sensor);

        sensorDataRepository.save(sensorData);

        List<SensorData> responseList =  restTemplate.getForObject(baseUrl, List.class);

        System.out.println(responseList);

        assertThat(responseList.size()).isEqualTo(1);
        assertThat(responseList.contains(sensorData));

    }

    @Test
    void testGetAllLastUpdate() {

        String baseUrl = "http://localhost";

        baseUrl = baseUrl.concat(":").concat(port + "").concat("/api/v1/lastUpdate");

        Sensor sensor = new Sensor("24E124136B326431");
        sensorReposistory.save(sensor);
        LocalDateTime dateTime = Instant.parse("2022-10-28T12:22:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        SensorData sensorData = new SensorData(17.5, 20, dateTime, sensor);

        sensorDataRepository.save(sensorData);

        List<SensorData> responseList =  restTemplate.getForObject(baseUrl, List.class);

        System.out.println(responseList);

        assertThat(responseList.size()).isEqualTo(1);
        assertThat(responseList.contains(sensorData));

    }

    @Test
    void testGetDataLastHour() {

        Sensor sensor = new Sensor("24E124136B326431");
        sensorReposistory.save(sensor);
        LocalDateTime dateTime = Instant.parse("2023-02-01T03:02:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        SensorData sensorData = new SensorData(17.5, 20, dateTime, sensor);

        sensorDataRepository.save(sensorData);

        String baseUrl = "http://localhost";

        baseUrl = baseUrl.concat(":").concat(port + "").concat("/api/v1/lastHourData?deviceId=24E124136B326431");



        List responseList =  restTemplate.getForObject(baseUrl, List.class);

        System.out.println(responseList);

        assertThat(responseList.size()).isEqualTo(1);
        assertThat(responseList.contains(sensorData));

    }
    @Test
    void testGetDataLastWeek() {

        Sensor sensor = new Sensor("24E124136B326431");
        sensorReposistory.save(sensor);
        LocalDateTime dateTime = Instant.parse("2023-02-01T03:02:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        SensorData sensorData = new SensorData(17.5, 20, dateTime, sensor);

        sensorDataRepository.save(sensorData);

        String baseUrl = "http://localhost";

        baseUrl = baseUrl.concat(":").concat(port + "").concat("/api/v1/lastWeekData?deviceId=24E124136B326431");



        List responseList =  restTemplate.getForObject(baseUrl, List.class);

        System.out.println(responseList);

        assertThat(responseList.size()).isEqualTo(1);
        assertThat(responseList.contains(sensorData));
    }
    @Test
    void testGetDatabetweentwodates() {

        Sensor sensor = new Sensor("24E124136B326431");
        sensorReposistory.save(sensor);
        LocalDateTime dateTime = Instant.parse("2022-12-11T02:02:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        SensorData sensorData = new SensorData(17.5, 20, dateTime, sensor);

        sensorDataRepository.save(sensorData);

        String baseUrl = "http://localhost";

        baseUrl = baseUrl.concat(":").concat(port + "").concat("/api/v1/datePicker?deviceId=24E124136B326431&fromRecievedAt=10.12.2022&toRecievedAt=11.12.2022");



        List responseList =  restTemplate.getForObject(baseUrl, List.class);

        System.out.println(responseList);

        assertThat(responseList.size()).isEqualTo(1);
        assertThat(responseList.contains(sensorData));
    }
    @Test
    void testFindSensorWithId() {

        Sensor sensor = new Sensor("24E124136B326431");
        sensorReposistory.save(sensor);
        LocalDateTime dateTime = Instant.parse("2022-12-11T02:02:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        SensorData sensorData = new SensorData(17.5, 20, dateTime, sensor);

        sensorDataRepository.save(sensorData);

        String baseUrl = "http://localhost";

        baseUrl = baseUrl.concat(":").concat(port + "").concat("/api/v1/findSensorById?deviceId=24E124136B326431");



        List responseList =  restTemplate.getForObject(baseUrl, List.class);

        System.out.println(responseList);

        assertThat(responseList.size()).isEqualTo(1);
        assertThat(responseList.contains(sensorData));
    }
}
