package de.adesso.simulationselfdrivingvehicle.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.adesso.simulationselfdrivingvehicle.dto.VehicleDTO;
import de.adesso.simulationselfdrivingvehicle.entities.Vehicle;
import de.adesso.simulationselfdrivingvehicle.mapper.VehicleMapper;
import de.adesso.simulationselfdrivingvehicle.repositories.VehicleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VehicleServiceTest {

    @Mock
    private SequenceGeneratorService sequenceGeneratorServiceTest;
    @Mock
    private VehicleRepository vehicleRepositoryTest;
    @Mock
    private VehicleMapper vehicleMapperTest;
    @InjectMocks
    private VehicleService vehicleServiceTest;

    @BeforeEach
    void setUp() {
        vehicleServiceTest=new VehicleService(sequenceGeneratorServiceTest,vehicleRepositoryTest,vehicleMapperTest);
    }

    @Test
    void findAll() {
        vehicleServiceTest.findAll();
        verify(vehicleRepositoryTest).findAll();
    }

    @Test
    void findById() {

        long testId= 123456L;
        final Vehicle value = new Vehicle();
        given(vehicleRepositoryTest.findById(testId)).willReturn(Optional.of(value));

        vehicleServiceTest.findById(testId);

        ArgumentCaptor<Long> idCaptor = ArgumentCaptor.forClass(Long.class);
        assertAll(
                () -> verify(vehicleRepositoryTest).findById(idCaptor.capture()),
                () -> assertEquals(testId, idCaptor.getValue())
        );
    }

    @Test
    void save() {
        //given
        Vehicle vehicle = new Vehicle();
        final VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setMaximalSpeed(0.0);
        //when
        when(vehicleMapperTest.entityToDto(vehicle)).thenReturn(vehicleDTO);
        when(vehicleRepositoryTest.save(vehicle)).thenReturn(vehicle);
        final VehicleDTO saved = vehicleServiceTest.save(vehicleDTO);

        // Then
        final ArgumentCaptor<Vehicle> argumentCaptor = ArgumentCaptor.forClass(Vehicle.class);
        verify(vehicleMapperTest, times(1)).entityToDto(argumentCaptor.capture());
        verify(vehicleRepositoryTest, times(1)).save(argumentCaptor.capture());

        vehicle = argumentCaptor.getValue();
        Assertions.assertEquals(saved,vehicleDTO);
        Assertions.assertEquals(saved.getMaximalSpeed(), vehicle.getMaximalSpeed());
        Assertions.assertNotNull(vehicle.getCreatedTime());

    }

    @Test
    void update() {
        // given
        Vehicle vehicle = new Vehicle();
        final VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setMaximalSpeed(0.0);

        // when
        when(vehicleRepositoryTest.findById(vehicle.getId())).thenReturn(Optional.of(vehicle));
        //when(vehicleRepositoryTest.save(vehicle)).thenReturn(vehicle);

        VehicleDTO updated = vehicleServiceTest.update(vehicleDTO.getId(),vehicleDTO);
        // then
        ArgumentCaptor<Vehicle> argumentCaptor = ArgumentCaptor.forClass(Vehicle.class);
        verify(vehicleRepositoryTest, times(1)).findById(vehicle.getId());
        //verify(vehicleRepositoryTest, times(1)).save(argumentCaptor.capture());
        assertEquals(updated, vehicleDTO);

    }

    @Test
    void remove() {
        //given
        long testId= 123L;
        final Vehicle value = new Vehicle();

        //when
        when(vehicleRepositoryTest.findById(testId)).thenReturn(Optional.of(value));

        vehicleServiceTest.remove(testId);
        //then
        ArgumentCaptor<Long> idCaptor = ArgumentCaptor.forClass(Long.class);
        verify(vehicleRepositoryTest,times(1)).findById(idCaptor.capture());

    }

    @Test
    void removeAll() {
        vehicleRepositoryTest.deleteAll();
        verify(vehicleRepositoryTest,times(1)).deleteAll();
        assertThat(vehicleRepositoryTest.findAll().size()).isEqualTo(0);

    }


}