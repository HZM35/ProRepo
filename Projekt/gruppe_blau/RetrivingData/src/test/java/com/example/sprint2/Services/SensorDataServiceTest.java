package com.example.sprint2.Services;

import com.example.sprint2.Entities.SensorData;
import com.example.sprint2.Repositories.SensorDataRepository;
import com.example.sprint2.Repositories.SensorReposistory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
class SensorDataServiceTest {


    public SensorReposistory sensorRepository;
     public SensorDataRepository sensorDataRepository= Mockito.mock(SensorDataRepository.class);



    public SensorDataService sensorDataService;
    @BeforeEach
    void setUp() { sensorDataService = new SensorDataService(sensorDataRepository);}


    @Test
    void getAllLastUpdate() {

        //when
        sensorDataService.getAllLastUpdate();
        //then
        verify(sensorDataRepository).getLastUpdate();

    }

    @Test
    void getsensorIdWithLastUpdate() {

    //when
        String string = "24E124136B326431";
        sensorDataService.getsensorIdWithLastUpdate(string);

    //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(sensorDataRepository).getsensorIdWithLastUpdate(stringArgumentCaptor.capture());
        String capturedString = stringArgumentCaptor.getValue();

        assertEquals(string,capturedString);
    }

    @Test
    void getDataLastHour() {
        //when
        String lastHourTime = "2022-10-28T12:00:03.131285660Z";
        LocalDateTime dateTimetest = Instant.parse("2022-10-29T12:00:03.131285660Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        String string = "24E124136B326431";
        sensorDataService.getDataLastHour(string, dateTimetest);

        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<LocalDateTime> localDataTimeArgumentCaptor2 = ArgumentCaptor.forClass(LocalDateTime.class);
        verify(sensorDataRepository).getDataLastHour(stringArgumentCaptor.capture(),localDataTimeArgumentCaptor2.capture());
        String capturedString = stringArgumentCaptor.getValue();
        LocalDateTime capturedLocalDateTime = localDataTimeArgumentCaptor2.getValue();

        assertThat(capturedString).isEqualTo(string);
        assertThat(capturedLocalDateTime).isEqualTo(dateTimetest);

    }

    @Test
    void getSensorDataBetweenTwoDates() {

        String deviceIdInput = "24E124136B326431";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        LocalDate dateTimeFrom = LocalDate.parse("27.10.2022",formatter);
        LocalDate dateTimeTo = LocalDate.parse("02.11.2022",formatter);

        LocalDateTime from = dateTimeFrom.atStartOfDay();
        LocalDateTime to = dateTimeTo.atTime(23,59,59,999999);

        List <SensorData> list = sensorDataRepository.getSensorDataBetweenTwoDates("24E124136B326431",from,to);

        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<LocalDateTime> localDataTimeArgumentCaptor1 = ArgumentCaptor.forClass(LocalDateTime.class);
        ArgumentCaptor<LocalDateTime> localDataTimeArgumentCaptor2 = ArgumentCaptor.forClass(LocalDateTime.class);

        verify(sensorDataRepository).getSensorDataBetweenTwoDates(stringArgumentCaptor.capture(),localDataTimeArgumentCaptor1.capture(),localDataTimeArgumentCaptor2.capture());

        String capturedString = stringArgumentCaptor.getValue();
        LocalDateTime capturedLocaldateTime1 = localDataTimeArgumentCaptor1.getValue();
        LocalDateTime capturedLocaldateTime2 = localDataTimeArgumentCaptor2.getValue();

        assertThat(capturedString).isEqualTo("24E124136B326431");
        assertThat(capturedLocaldateTime1).isEqualTo(from);
        assertThat(capturedLocaldateTime2).isEqualTo(to);
    }

    @Test
    void testGetDataLastWeek() {
        //when
        String lastHourTime = "2022-10-28T12:00:03.131285660Z";
        LocalDateTime dateTimetest = Instant.parse("2022-10-29T12:00:03.131285660Z").atZone(ZoneId.systemDefault()).toLocalDateTime();
        String string = "24E124136B326431";
        sensorDataService.getDataLastHour(string , dateTimetest);

        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<LocalDateTime> localDataTimeArgumentCaptor2 = ArgumentCaptor.forClass(LocalDateTime.class);
        verify(sensorDataRepository).getDataLastHour(stringArgumentCaptor.capture(),localDataTimeArgumentCaptor2.capture());
        String capturedString = stringArgumentCaptor.getValue();
        LocalDateTime capturedLocalDateTime = localDataTimeArgumentCaptor2.getValue();

        assertThat(capturedString).isEqualTo(string);
        assertThat(capturedLocalDateTime).isEqualTo(dateTimetest);

    }
}