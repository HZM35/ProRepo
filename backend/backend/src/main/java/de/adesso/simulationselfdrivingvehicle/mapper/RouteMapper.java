package de.adesso.simulationselfdrivingvehicle.mapper;

import de.adesso.simulationselfdrivingvehicle.dto.RouteDTO;
import de.adesso.simulationselfdrivingvehicle.entities.Route;
import org.mapstruct.*;

import java.util.List;

/**
 * the Mapper for Vehicle Route
 */

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RouteMapper {
    Route toEntity(RouteDTO routeDto);

    RouteDTO toDto(Route route);

    List<RouteDTO> ROUTE_DTOS(List<Route> routes);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Route partialUpdate(RouteDTO routeDto, @MappingTarget Route route);
}