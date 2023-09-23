package de.adesso.simulationselfdrivingvehicle.services;

import de.adesso.simulationselfdrivingvehicle.dto.RouteDTO;
import de.adesso.simulationselfdrivingvehicle.dto.RouteSectionDTO;
import de.adesso.simulationselfdrivingvehicle.dto.VehicleDTO;
import de.adesso.simulationselfdrivingvehicle.entities.*;
import de.adesso.simulationselfdrivingvehicle.error.RouteNotFoundException;
import de.adesso.simulationselfdrivingvehicle.mapper.RouteMapper;
import de.adesso.simulationselfdrivingvehicle.mapper.VehicleMapper;
import de.adesso.simulationselfdrivingvehicle.repositories.CurveRepository;
import de.adesso.simulationselfdrivingvehicle.repositories.RouteRepository;
import de.adesso.simulationselfdrivingvehicle.repositories.StraightRouteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class) // Tells Junit to use Mockito
class RouteServiceTest {

    @Mock
    private RouteRepository routeRepositoryTest;
    @Mock
    private CurveRepository curveRepositoryTest;
    @Mock
    private StraightRouteRepository straightRouteRepositoryTest;
    @Mock
    private SequenceGeneratorService sequenceGeneratorServiceTest;
    @Mock
    private RouteMapper routeMapperTest;


    @InjectMocks // Mocks from above will be used here to create the routeServiceTest
    private RouteService routeServiceTest;

    @BeforeEach
    void setUp() {
        routeServiceTest=new RouteService(routeRepositoryTest,curveRepositoryTest,straightRouteRepositoryTest,sequenceGeneratorServiceTest,routeMapperTest);
    }

    @Nested // Grouping for several tests... One nested class per method in the testee
    public class FindById {
        @Test
        void throwsRouteNotFoundException() {
            // Assertions -> checks the test execution
            Assertions.assertThrows(RouteNotFoundException.class, () -> routeServiceTest.findById(123));
        }

        @Test
        void returnARouteDTO() {
            // Given
            long testId= 123456L;
            final Route value = new Route();
            // BDDMockito.given -> How a mock should behave
            given(routeRepositoryTest.findById(testId)).willReturn(Optional.of(value));

            // When
            final RouteDTO route = routeServiceTest.findById(testId);

            ArgumentCaptor<Long> idCaptor = ArgumentCaptor.forClass(Long.class);
            ArgumentCaptor<RouteDTO> argumentCaptor = ArgumentCaptor.forClass(RouteDTO.class);
            assertAll(
                    () -> verify(routeRepositoryTest).findById(idCaptor.capture()),
                   // () -> assertNotNull(route),
                   // () -> assertEquals(route, argumentCaptor.capture()),
                    () -> assertEquals(testId,idCaptor.getValue())
            );
        }

    }

    @Nested
    public class Save {
        @Test
        void save() {
            //given
            Route route = new Route();
            final RouteDTO routeDTO = new RouteDTO();
            routeDTO.setRouteSections(Collections.emptyList());
            route.setDetails("Die Strecke besteht aus nur geraden Streckenabschnitten");
            //when
            when(routeMapperTest.toDto(route)).thenReturn(routeDTO);
            when(routeRepositoryTest.save(route)).thenReturn(route);
            final RouteDTO saved = routeServiceTest.save(routeDTO);

            // Then
            final ArgumentCaptor<Route> argumentCaptor = ArgumentCaptor.forClass(Route.class);
            verify(routeMapperTest, times(1)).toDto(argumentCaptor.capture());
            verify(routeRepositoryTest, times(1)).save(argumentCaptor.capture());

            route = argumentCaptor.getValue();
            Assertions.assertEquals(saved,routeDTO);
            Assertions.assertEquals(saved.getRouteSections(), route.getRouteSections());
            Assertions.assertNotNull(route.getCreatedTime());
            Assertions.assertNotNull(route.getId());

        }
    }

    @Nested
    public class update {
        @Test
        void update() {
            // given
            Route route = new Route();
            final RouteDTO routeDTO = new RouteDTO();
            routeDTO.setRouteSections(Collections.emptyList());

            // when
            when(routeRepositoryTest.findById(route.getId())).thenReturn(Optional.of(route));
            when(routeRepositoryTest.save(route)).thenReturn(route);

            RouteDTO updated = routeServiceTest.update(routeDTO.getId(), routeDTO);
            // then
            ArgumentCaptor<Route> argumentCaptor = ArgumentCaptor.forClass(Route.class);
            verify(routeRepositoryTest, times(1)).findById(route.getId());
            verify(routeRepositoryTest, times(1)).save(argumentCaptor.capture());
            assertEquals(updated, routeDTO);

        }

        @Test
        void throwsRouteNotFoundException() {
            // Assertions -> checks the test execution
            Assertions.assertThrows(RouteNotFoundException.class, () -> routeServiceTest.findById(123));
        }
    }

    @Nested
    public class remove {
        @Test
        void remove() {
            //given
            long testId = 123L;
            final Route value = new Route();

            //when
            when(routeRepositoryTest.findById(testId)).thenReturn(Optional.of(value));

            routeServiceTest.remove(testId);
            //then
            ArgumentCaptor<Long> idCaptor = ArgumentCaptor.forClass(Long.class);
            verify(routeRepositoryTest, times(1)).findById(idCaptor.capture());
        }
        @Test
        void throwsRouteNotFoundException() {
            // Assertions -> checks the test execution
            Assertions.assertThrows(RouteNotFoundException.class, () -> routeServiceTest.findById(123));
        }
    }

    @Test
    void removeAll() {
        routeRepositoryTest.deleteAll();
        verify(routeRepositoryTest,times(1)).deleteAll();
        assertThat(routeRepositoryTest.findAll().size()).isEqualTo(0);
    }


}