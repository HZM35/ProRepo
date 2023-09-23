package de.adesso.simulationselfdrivingvehicle.mapper;

import de.adesso.simulationselfdrivingvehicle.dto.RouteSectionDTO;
import de.adesso.simulationselfdrivingvehicle.entities.RouteSection;
import org.mapstruct.*;

/**
 * the Mapper for RouteSection
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RouteSectionMapper {
    RouteSection toEntity(RouteSectionDTO routeSectionDto);

    RouteSectionDTO toDto(RouteSection routeSection);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    RouteSection partialUpdate(RouteSectionDTO routeSectionDto, @MappingTarget RouteSection routeSection);
}