package com.example.sprint2.Repositories;

import com.example.sprint2.Entities.Sensor;
import com.example.sprint2.Entities.SensorData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SensorReposistoryTest {

    Sensor sensor;

    SensorData sensorData;

    @Autowired
    SensorReposistory sensorRepository;
    @Autowired
    SensorDataRepository sensorDataRepository;

    @BeforeEach
    void setUp() {
        Sensor sensor = new Sensor("24E124136B326431");
        Sensor sensor2 = new Sensor("25E124136B326431");
        sensorRepository.save(sensor);
        sensorRepository.save(sensor2);
        LocalDateTime dateTime = Instant.parse("2022-10-28T12:22:03.131285660Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime dateTime2 = Instant.parse("2022-10-29T12:22:03.131285660Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime dateTime3 = Instant.parse("2022-10-30T12:22:03.131285660Z").atZone(ZoneId.systemDefault()).toLocalDateTime();

        SensorData sensorData = new SensorData(17.5, 20, dateTime, sensor);
        SensorData sensorData2 = new SensorData(17.5, 20, dateTime2, sensor);
        SensorData sensorData3 = new SensorData(17.5, 20, dateTime3, sensor);
        SensorData sensorData4 = new SensorData(17.5, 20, dateTime2, sensor);
        SensorData sensorData5 = new SensorData(17.5, 20, dateTime2, sensor);
        List<SensorData> sensorDataList = new ArrayList<>();
        sensorDataList.add(sensorData);
        sensorDataList.add(sensorData2);
        sensorDataList.add(sensorData3);
        sensorDataList.add(sensorData4);
        sensorDataList.add(sensorData5);
        sensorDataRepository.saveAll(sensorDataList);
    }

    @Test
    void getAllId() {

        //when

        List<String> list = sensorRepository.getAllId();
        List<String> expectedList = new ArrayList<>();
        expectedList.add("24E124136B326431");
        expectedList.add("25E124136B326431");

        //then
        assertEquals(expectedList, list);
        assertThat(list).isEqualTo(expectedList);

    }

    @Test
    void getAllId2() {
        //given

        List<String> expected = new ArrayList<>();
        expected.add("24E124136B326431");
        expected.add("25E124136B326431");
        //when
        List<String> strList = sensorRepository.getAllId();
        //then
        assertThat(strList).isEqualTo(expected);
    }
}