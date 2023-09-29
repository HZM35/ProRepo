package com.example.sprint2.Services;

import com.example.sprint2.Entities.Sensor;
import com.example.sprint2.Repositories.SensorDataRepository;
import com.example.sprint2.Repositories.SensorReposistory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.configuration.IMockitoConfiguration;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SensorServiceTest {

    @Mock private SensorReposistory sensorRepository;

    private SensorService sensorService;

    @BeforeEach
    void setUp() {

        sensorService = new SensorService(sensorRepository);
    }



    @Test
    void saveSensor() {

        Sensor sensor = new Sensor("24E124136B326431");

        sensorService.saveSensor(sensor);
        
        ArgumentCaptor <Sensor> sensorArgumentCaptor = ArgumentCaptor.forClass(Sensor.class);
        verify(sensorRepository).save(sensorArgumentCaptor.capture());
        Sensor capturedSensor = sensorArgumentCaptor.getValue();

        assertThat(capturedSensor).isEqualTo(sensor);
    }

    @Test
    void getAllId() {
        // when
        sensorService.getAllId();
        // then
        verify(sensorRepository).getAllId();
    }

}
