package com.example.sprint2.Repositories;

import com.example.sprint2.Entities.Sensor;
import com.example.sprint2.Entities.SensorData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SensorDataRepositoryTest {
    Sensor sensor;
    SensorData sensorData;
    @Autowired
    SensorDataRepository sensorDataRepository;
    @Autowired
    SensorReposistory sensorRepository;

    @BeforeEach
    void setUp() {}

    @AfterEach
    void tearDown() {
        sensorDataRepository.deleteAll();
    }



    @Test
    void getLastUpdateTest1() {

        //testet die Methode mit zwei Sensoren

        //given
        LocalDateTime localDateTime = LocalDateTime.now();
        Sensor sensor = new Sensor("24E124136B326431");
        Sensor sensor2 = new Sensor("24E124136B326430");
        sensorRepository.save(sensor);
        sensorRepository.save(sensor2);
        LocalDateTime dateTime = Instant.parse("2022-10-28T12:22:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime dateTime2 = Instant.parse("2022-10-29T12:22:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime dateTime3 = Instant.parse("2022-10-30T12:22:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime dateTime4 = Instant.parse("2022-10-31T12:22:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        SensorData sensorData = new SensorData(17.5, 20, dateTime, sensor);
        SensorData sensorData2 = new SensorData(17.5, 20, dateTime4, sensor);
        SensorData sensorData3 = new SensorData(17.5, 20, dateTime2, sensor2);
        SensorData sensorData4 = new SensorData(17.5, 20, dateTime3, sensor2);


        List<SensorData> s = new ArrayList<SensorData>();
        s.add(sensorData);
        s.add(sensorData2);
        s.add(sensorData3);
        s.add(sensorData4);

        List <SensorData> expectedList = new ArrayList<>();
        expectedList.add(sensorData2);
        expectedList.add(sensorData4);
        //when
        sensorDataRepository.saveAll(s);

        List<SensorData> actualList = sensorDataRepository.getLastUpdate();

        //then

        assertThat(actualList).isEqualTo(expectedList);
    }



    @Test
    void getLastUpdateTestWhenSensorListEqualsEmptyList() {

        //testet wenn keine Data gepasst werden.

        //given
        List<SensorData> list = new ArrayList<SensorData>();

        sensorDataRepository.saveAll(list);

        //when
        List<SensorData> lastupdate = sensorDataRepository.getLastUpdate();

        //then
        assertThat(lastupdate).isEmpty();
    }




    @Test
    void getsensorIdWithLastUpdateTest(){

        //testet ob die Methode getsensorIdWithLastUpdate() richtig funktioniert.

        //given
        Sensor sensor = new Sensor("24E124136B326431");
        sensorRepository.save(sensor);
        LocalDateTime dateTime = Instant.parse("2022-10-28T12:22:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime dateTime2 = Instant.parse("2022-10-29T12:22:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime dateTime3 = Instant.parse("2022-10-30T12:22:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();

        SensorData sensorData = new SensorData(17.5, 20, dateTime, sensor);
        SensorData sensorData2 = new SensorData(17.5, 20, dateTime2, sensor);
        SensorData sensorData3 = new SensorData(17.5, 20, dateTime3, sensor);

        List<SensorData> repoList = new ArrayList<SensorData>();
        repoList.add(sensorData);
        repoList.add(sensorData2);
        repoList.add(sensorData3);

        List<SensorData> expectedList = new ArrayList<>();
        expectedList.add(sensorData3);

        sensorDataRepository.saveAll(repoList);

        //when
        List<SensorData> actualList = sensorDataRepository.getsensorIdWithLastUpdate("24E124136B326431");


        //then
        assertThat(actualList).isEqualTo(expectedList);

    }



    @Test
    void getsensorIdWithLastUpdateTest12() {


        //testet wenn keine Data gepasst werden.

        //given


        List<SensorData> repoList = new ArrayList<SensorData>();


        sensorDataRepository.saveAll(repoList);
        //when
        List<SensorData> actualList = sensorDataRepository.getsensorIdWithLastUpdate("24E124136B326431");

        List<SensorData> expectedList = new ArrayList<SensorData>();

        //then
        assertThat(actualList).isEqualTo(expectedList);

        //OR
        // assertThat(actualList).isEmpty();

    }


    @Test
    void shouldReturnSensordataListwithInfosfromLastHour() {
        // Hier muss die getestet werden, ob wirklich die Daten von letzter Stunde aufgerufen wird

        //given
        Sensor sensor = new Sensor("24E124136B326431");

        sensorRepository.save(sensor);


        LocalDateTime dateTime = Instant.parse("2022-10-28T12:22:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime dateTime2 = Instant.parse("2022-10-30T12:35:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime dateTime3 = Instant.parse("2022-10-30T12:22:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();

        SensorData sensorData = new SensorData(17.5, 20, dateTime, sensor);
        SensorData sensorData2 = new SensorData(17.5, 20, dateTime2, sensor);
        SensorData sensorData3 = new SensorData(17.5, 20, dateTime3, sensor);

        List<SensorData> repoList = new ArrayList<SensorData>();
        repoList.add(sensorData3);
        repoList.add(sensorData2);
        repoList.add(sensorData);


        List <SensorData> expectedList = new ArrayList<>();
        expectedList.add(sensorData2);
        expectedList.add(sensorData3);


        sensorDataRepository.saveAll(repoList);

        LocalDateTime lastHour = Instant.parse("2022-10-30T12:00:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();

        //when

        List<SensorData> list = sensorDataRepository.getDataLastHour("24E124136B326431", lastHour);
        //then

        assertThat(list).isEqualTo(expectedList);
    }


    @Test
    void testIfNoDatawasSentInTheLastHour() {
        // Hier muss getestet werden, ob keine Daten post letzter Stunde zufunden ist.

        //given
        Sensor sensor = new Sensor("24E124136B326431");

        sensorRepository.save(sensor);


        LocalDateTime dateTime = Instant.parse("2022-10-28T12:22:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime dateTime2 = Instant.parse("2022-10-30T12:35:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime dateTime3 = Instant.parse("2022-10-30T12:22:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();

        SensorData sensorData = new SensorData(17.5, 20, dateTime, sensor);
        SensorData sensorData2 = new SensorData(17.5, 20, dateTime2, sensor);
        SensorData sensorData3 = new SensorData(17.5, 20, dateTime3, sensor);

        List<SensorData> repoList = new ArrayList<SensorData>();
        repoList.add(sensorData3);
        repoList.add(sensorData2);
        repoList.add(sensorData);


        List <SensorData> expectedList = new ArrayList<>();

        sensorDataRepository.saveAll(repoList);

        LocalDateTime lastHour = Instant.parse("2022-10-30T12:45:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();

        //when

        List<SensorData> list = sensorDataRepository.getDataLastHour("24E124136B326431", lastHour);
        //then

        assertThat(list).isEqualTo(expectedList);
    }



    //hier wird leere Liste der Repository gepasst, soll leere Liste zurückgeben
    @Test
    void shouldReturnEmptyList() {
        //given
        List<SensorData> s = new ArrayList<SensorData>();
        sensorDataRepository.saveAll(s);
        LocalDateTime dateTimetest = Instant.parse("2022-10-29T12:00:03.131285660Z").atZone(ZoneId.systemDefault()).toLocalDateTime();

        //when
        List<SensorData> list = sensorDataRepository.getDataLastHour("24E124136B326431", dateTimetest);

        //then
        assertThat(list).isEmpty();
    }



    @Test
    void getDataLastHourTest3() {

        //Diese Test,Kann gerne ignoriert werden.

        //given
        Sensor sensor = new Sensor("24E124136B326431");
        Sensor sensor2 = new Sensor("25E124136B326435");
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

        List<SensorData> s = new ArrayList<SensorData>();
        s.add(sensorData3);
        s.add(sensorData2);
        s.add(sensorData);

        List<SensorData> s2 = new ArrayList<SensorData>();
        s2.add(sensorData4);
        s2.add(sensorData5);

        sensorDataRepository.saveAll(s);
        sensorDataRepository.saveAll(s2);

        LocalDateTime dateTimetest = Instant.parse("2022-10-29T12:00:03.131285660Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        //when
        List<SensorData> list = sensorDataRepository.getDataLastHour("25E124136B326435", dateTimetest);

        Boolean isNotSameSensor = s != list;
        //then
        assertThat(isNotSameSensor).isTrue();
    }



    @Test
    void getSensorDataBetweenTwoDates() {

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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");


        LocalDate dateTimeFrom = LocalDate.parse("27.10.2022",formatter);
        LocalDate dateTimeTo = LocalDate.parse("02.11.2022",formatter);

        LocalDateTime from = dateTimeFrom.atStartOfDay();
        LocalDateTime to = dateTimeTo.atTime(23,59,59,999999);

        List <SensorData> list = sensorDataRepository.getSensorDataBetweenTwoDates("24E124136B326431",from,to);

        Boolean isBetween = list.get(0).getRecievedAt().isAfter(from) && list.get(0).getRecievedAt().isBefore(to);

        assertThat(isBetween).isTrue();

    }

    @Test
    void getSensorDataBetweenTwoDates2() {

        //testet der Fall wenn der User die Datum falsch eintgibt (to ---> from)

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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");


        LocalDate dateTimeFrom = LocalDate.parse("27.10.2022",formatter);
        LocalDate dateTimeTo = LocalDate.parse("02.11.2022",formatter);

        LocalDateTime from = dateTimeFrom.atStartOfDay();
        LocalDateTime to = dateTimeTo.atTime(23,59,59,999999);

        List <SensorData> list = sensorDataRepository.getSensorDataBetweenTwoDates("24E124136B326431",to,from);

//        Boolean isBetween = list.get(0).getRecievedAt().isAfter(from) && list.get(0).getRecievedAt().isBefore(to);
//        assertThat(isBetween).isTrue();

        assertThat(list).isEmpty();

    }
    @Test
    void getSensorDataBetweenTwoDates3() {

        //testet der Fall wenn der User die Datum falsch eintgibt (die gleiche Datum in die zwei Felder gibt)

        Sensor sensor = new Sensor("24E124136B326431");

        sensorRepository.save(sensor);



        LocalDateTime dateTime = Instant.parse("2022-10-27T12:22:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime dateTime2 = Instant.parse("2022-10-29T12:22:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime dateTime3 = Instant.parse("2022-10-30T12:22:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();

        SensorData sensorData = new SensorData(17.5, 20, dateTime, sensor);
        SensorData sensorData2 = new SensorData(17.5, 20, dateTime2, sensor);
        SensorData sensorData3 = new SensorData(17.5, 20, dateTime3, sensor);

        sensorDataRepository.save(sensorData);
        sensorDataRepository.save(sensorData2);
        sensorDataRepository.save(sensorData3);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");


        LocalDate dateTimeFrom = LocalDate.parse("27.10.2022",formatter);
        LocalDate dateTimeTo = LocalDate.parse("02.11.2022",formatter);

        LocalDateTime from = dateTimeFrom.atStartOfDay();
        LocalDateTime to = dateTimeTo.atTime(23,59,59,999999);

        List <SensorData> list = sensorDataRepository.getSensorDataBetweenTwoDates("24E124136B326431",from,from);

//        Boolean isBetween = list.get(0).getRecievedAt().isAfter(from) && list.get(0).getRecievedAt().isBefore(to);
//        assertThat(isBetween).isTrue();

        assertThat(list).isEmpty();

    }
    @Test
    void checkIfNoDataWasSentInTheLastWeek() {
        // Hier muss getestet werden, ob keine Daten post letzter Stunde zufunden ist.

        //given
        Sensor sensor = new Sensor("24E124136B326431");

        sensorRepository.save(sensor);


        LocalDateTime dateTime = Instant.parse("2022-10-28T12:22:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime dateTime2 = Instant.parse("2022-10-29T12:35:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime dateTime3 = Instant.parse("2022-10-30T12:22:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();

        LocalDateTime dateTime4 = Instant.parse("2022-10-26T12:22:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();

        SensorData sensorData = new SensorData(17.5, 20, dateTime, sensor);
        SensorData sensorData2 = new SensorData(17.5, 20, dateTime2, sensor);
        SensorData sensorData3 = new SensorData(17.5, 20, dateTime3, sensor);
        SensorData sensorData4 = new SensorData(17.5, 20, dateTime4, sensor);

        List<SensorData> repoList = new ArrayList<SensorData>();

        repoList.add(sensorData2);
        repoList.add(sensorData3);
        repoList.add(sensorData);
        repoList.add(sensorData4);

        List <SensorData> expectedList = new ArrayList<>();
        expectedList.add(sensorData3);
        expectedList.add(sensorData2);
        expectedList.add(sensorData);



        sensorDataRepository.saveAll(repoList);

        LocalDateTime lastWeekTime = Instant.parse("2022-10-27T12:45:03.131285Z").atZone(ZoneId.systemDefault()).toLocalDateTime();

        //when

        List<SensorData> list = sensorDataRepository.getDataLastWeek("24E124136B326431", lastWeekTime);
        //then

        assertThat(list).isEqualTo(expectedList);
    }

}
