package de.adesso.simulationselfdrivingvehicle.mapper;

import de.adesso.simulationselfdrivingvehicle.dto.RouteSectionDTO;
import de.adesso.simulationselfdrivingvehicle.entities.Point;
import de.adesso.simulationselfdrivingvehicle.entities.RouteSection;
import de.adesso.simulationselfdrivingvehicle.enums.RouteSectionType;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-28T19:40:12+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Eclipse Adoptium)"
)
@Component
public class RouteSectionMapperImpl implements RouteSectionMapper {

    @Override
    public RouteSection toEntity(RouteSectionDTO routeSectionDto) {
        if ( routeSectionDto == null ) {
            return null;
        }

        RouteSection routeSection = new RouteSection();

        routeSection.setId( routeSectionDto.getId() );
        routeSection.setCreatedTime( routeSectionDto.getCreatedTime() );
        routeSection.setUpdatedTime( routeSectionDto.getUpdatedTime() );
        routeSection.setStartPointLeft( routeSectionDto.getStartPointLeft() );
        routeSection.setEndPointLeft( routeSectionDto.getEndPointLeft() );
        routeSection.setStartPointRight( routeSectionDto.getStartPointRight() );
        routeSection.setEndPointRight( routeSectionDto.getEndPointRight() );
        routeSection.setDirectionOfTraffic( routeSectionDto.getDirectionOfTraffic() );
        routeSection.setType( routeSectionDto.getType() );
        routeSection.setControlPointLeft( routeSectionDto.getControlPointLeft() );
        routeSection.setControlPointRight( routeSectionDto.getControlPointRight() );

        return routeSection;
    }

    @Override
    public RouteSectionDTO toDto(RouteSection routeSection) {
        if ( routeSection == null ) {
            return null;
        }

        RouteSectionType type = null;
        Point startPointLeft = null;
        Point endPointLeft = null;
        Point startPointRight = null;
        Point endPointRight = null;
        Point controlPointLeft = null;
        Point controlPointRight = null;

        type = routeSection.getType();
        startPointLeft = routeSection.getStartPointLeft();
        endPointLeft = routeSection.getEndPointLeft();
        startPointRight = routeSection.getStartPointRight();
        endPointRight = routeSection.getEndPointRight();
        controlPointLeft = routeSection.getControlPointLeft();
        controlPointRight = routeSection.getControlPointRight();

        RouteSectionDTO routeSectionDTO = new RouteSectionDTO( type, startPointLeft, endPointLeft, startPointRight, endPointRight, controlPointLeft, controlPointRight );

        routeSectionDTO.setId( routeSection.getId() );
        routeSectionDTO.setCreatedTime( routeSection.getCreatedTime() );
        routeSectionDTO.setUpdatedTime( routeSection.getUpdatedTime() );
        routeSectionDTO.setDirectionOfTraffic( routeSection.getDirectionOfTraffic() );

        return routeSectionDTO;
    }

    @Override
    public RouteSection partialUpdate(RouteSectionDTO routeSectionDto, RouteSection routeSection) {
        if ( routeSectionDto == null ) {
            return null;
        }

        routeSection.setId( routeSectionDto.getId() );
        if ( routeSectionDto.getCreatedTime() != null ) {
            routeSection.setCreatedTime( routeSectionDto.getCreatedTime() );
        }
        if ( routeSectionDto.getUpdatedTime() != null ) {
            routeSection.setUpdatedTime( routeSectionDto.getUpdatedTime() );
        }
        if ( routeSectionDto.getStartPointLeft() != null ) {
            routeSection.setStartPointLeft( routeSectionDto.getStartPointLeft() );
        }
        if ( routeSectionDto.getEndPointLeft() != null ) {
            routeSection.setEndPointLeft( routeSectionDto.getEndPointLeft() );
        }
        if ( routeSectionDto.getStartPointRight() != null ) {
            routeSection.setStartPointRight( routeSectionDto.getStartPointRight() );
        }
        if ( routeSectionDto.getEndPointRight() != null ) {
            routeSection.setEndPointRight( routeSectionDto.getEndPointRight() );
        }
        if ( routeSectionDto.getDirectionOfTraffic() != null ) {
            routeSection.setDirectionOfTraffic( routeSectionDto.getDirectionOfTraffic() );
        }
        if ( routeSectionDto.getType() != null ) {
            routeSection.setType( routeSectionDto.getType() );
        }
        if ( routeSectionDto.getControlPointLeft() != null ) {
            routeSection.setControlPointLeft( routeSectionDto.getControlPointLeft() );
        }
        if ( routeSectionDto.getControlPointRight() != null ) {
            routeSection.setControlPointRight( routeSectionDto.getControlPointRight() );
        }

        return routeSection;
    }
}
