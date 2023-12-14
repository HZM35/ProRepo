package com.example.sprint2.Controllers;

import com.example.sprint2.Entities.Sensor;
import com.example.sprint2.Entities.SensorData;
import com.example.sprint2.Repositories.SensorDataRepository;
import com.example.sprint2.Repositories.SensorReposistory;
import com.example.sprint2.Services.SensorDataService;
import com.example.sprint2.Services.SensorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SensorDataController.class)
class SensorDataControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    SensorService service;
    @MockBean
    SensorReposistory sensorRepository;
    @MockBean
    SensorDataService sensorDataService;
    @MockBean
    SensorDataRepository sensorDataRepository;




    @Test
    void getAllLastUpdate() throws Exception {

        Sensor sensor = new Sensor("24E124136B326431");


        LocalDateTime dateTime3 = Instant.parse("2022-10-30T12:22:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        SensorData sensorData3 = new SensorData(17.5, 20, dateTime3, sensor);

        List<SensorData> list = new ArrayList<>();

        list.add(sensorData3);



        when(sensorDataService.getAllLastUpdate()).thenReturn(list);


        RequestBuilder request  = get("/api/v1/lastUpdate");
        MvcResult result = mvc.perform(request).andReturn();

        mvc.perform(get("/api/v1/lastUpdate")).
                andDo(print()).
                andExpect(status().isOk());

    }

    @Test
    void getDataLastHour() throws Exception {

        Sensor sensor = new Sensor("24E124136B326431");
        sensorRepository.save(sensor);

//        LocalDateTime lastHourTime = LocalDateTime.now().minusHours(1);

        LocalDateTime dateTime3 = Instant.parse("2022-11-28T11:19:30.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        SensorData sensorData3 = new SensorData(17.5, 20, dateTime3, sensor);

        List<SensorData> list = new ArrayList<>();
        list.add(sensorData3);

        sensorDataRepository.saveAll(list);

//        LocalDateTime lastHourTime = LocalDateTime.now().minusHours(1);

        LocalDateTime lastHourTime2 = Instant.parse("2022-11-28T11:10:20.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();

        when(sensorDataService.getDataLastHour("24E124136B326431",lastHourTime2)).thenReturn(list);

        RequestBuilder request  = get("/api/v1/lastHourData");
        MvcResult result = mvc.perform(request).andReturn();


        mvc.perform((get("http://localhost:8080/api/v1/lastHourData?deviceId=24E124136B326431"))).
                andDo(print()).
                andExpect(status().isOk());
    }

    @Test
    void getSensorDataBetweenTwoDates() throws Exception {

        Sensor sensor = new Sensor("24E124136B326431");

        sensorRepository.save(sensor);



        LocalDateTime dateTime = Instant.parse("2022-10-28T12:22:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime dateTime2 = Instant.parse("2022-10-29T12:22:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime dateTime3 = Instant.parse("2022-10-30T12:22:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();

        SensorData sensorData = new SensorData(17.5, 20, dateTime, sensor);
        SensorData sensorData2 = new SensorData(17.5, 20, dateTime2, sensor);
        SensorData sensorData3 = new SensorData(17.5, 20, dateTime3, sensor);

        sensorDataRepository.save(sensorData);
        sensorDataRepository.save(sensorData2);
        sensorDataRepository.save(sensorData3);

        List<SensorData> list = new ArrayList<>();
        list.add(sensorData);
        list.add(sensorData2);
        list.add(sensorData3);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");


        LocalDate dateTimeFrom = LocalDate.parse("27.10.2022",formatter);
        LocalDate dateTimeTo = LocalDate.parse("02.11.2022",formatter);

        LocalDateTime from = dateTimeFrom.atStartOfDay();
        LocalDateTime to = dateTimeTo.atTime(23,59,59,999999);

        when(sensorDataService.getSensorDataBetweenTwoDates("24E124136B326431",from,to)).thenReturn(list);

        RequestBuilder request  = get("/api/v1/datePicker");
        MvcResult result = mvc.perform(request).andReturn();


        mvc.perform((get("http://localhost:8080/api/v1/datePicker?deviceId=24E124136B326431&fromRecievedAt=27.10.2022&toRecievedAt=02.11.2022"))).
                andDo(print()).
                andExpect(status().isOk());

    }

    @Test
    void getsensorIdWithLastUpdate() throws Exception {

        Sensor sensor = new Sensor("24E124136B326431");

        sensorRepository.save(sensor);

        LocalDateTime dateTime = Instant.parse("2022-10-28T12:22:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime dateTime2 = Instant.parse("2022-10-29T12:22:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime dateTime3 = Instant.parse("2022-10-30T12:22:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();

        SensorData sensorData = new SensorData(17.5, 20, dateTime, sensor);
        SensorData sensorData2 = new SensorData(17.5, 20, dateTime2, sensor);
        SensorData sensorData3 = new SensorData(17.5, 20, dateTime3, sensor);

        sensorDataRepository.save(sensorData);
        sensorDataRepository.save(sensorData2);
        sensorDataRepository.save(sensorData3);
        List<SensorData> list = new ArrayList<>();
        list.add(sensorData);
        list.add(sensorData2);
        list.add(sensorData3);

        when(sensorDataService.getsensorIdWithLastUpdate("24E124136B326431")).thenReturn(list);

        RequestBuilder request  = get("/api/v1/findSensorById");
        MvcResult result = mvc.perform(request).andReturn();


        mvc.perform((get("http://localhost:8080/api/v1/findSensorById?deviceId=24E124136B326431"))).
                andDo(print()).
                andExpect(status().isOk());


    }
}