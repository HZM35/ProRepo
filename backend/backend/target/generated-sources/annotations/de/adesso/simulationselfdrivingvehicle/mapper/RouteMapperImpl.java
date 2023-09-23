package de.adesso.simulationselfdrivingvehicle.mapper;

import de.adesso.simulationselfdrivingvehicle.dto.RouteDTO;
import de.adesso.simulationselfdrivingvehicle.dto.RouteSectionDTO;
import de.adesso.simulationselfdrivingvehicle.entities.Point;
import de.adesso.simulationselfdrivingvehicle.entities.Route;
import de.adesso.simulationselfdrivingvehicle.entities.RouteSection;
import de.adesso.simulationselfdrivingvehicle.enums.RouteSectionType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-28T19:40:12+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Eclipse Adoptium)"
)
@Component
public class RouteMapperImpl implements RouteMapper {

    @Override
    public Route toEntity(RouteDTO routeDto) {
        if ( routeDto == null ) {
            return null;
        }

        Route route = new Route();

        route.setId( routeDto.getId() );
        route.setCreatedTime( routeDto.getCreatedTime() );
        route.setUpdatedTime( routeDto.getUpdatedTime() );
        route.setStartPoint( routeDto.getStartPoint() );
        route.setEndPoint( routeDto.getEndPoint() );
        route.setSumLength( routeDto.getSumLength() );
        route.setRouteSections( routeSectionDTOListToRouteSectionList( routeDto.getRouteSections() ) );
        route.setDetails( routeDto.getDetails() );

        return route;
    }

    @Override
    public RouteDTO toDto(Route route) {
        if ( route == null ) {
            return null;
        }

        RouteDTO routeDTO = new RouteDTO();

        routeDTO.setId( route.getId() );
        routeDTO.setCreatedTime( route.getCreatedTime() );
        routeDTO.setUpdatedTime( route.getUpdatedTime() );
        routeDTO.setStartPoint( route.getStartPoint() );
        routeDTO.setEndPoint( route.getEndPoint() );
        routeDTO.setSumLength( route.getSumLength() );
        routeDTO.setRouteSections( routeSectionListToRouteSectionDTOList( route.getRouteSections() ) );
        routeDTO.setDetails( route.getDetails() );

        return routeDTO;
    }

    @Override
    public List<RouteDTO> ROUTE_DTOS(List<Route> routes) {
        if ( routes == null ) {
            return null;
        }

        List<RouteDTO> list = new ArrayList<RouteDTO>( routes.size() );
        for ( Route route : routes ) {
            list.add( toDto( route ) );
        }

        return list;
    }

    @Override
    public Route partialUpdate(RouteDTO routeDto, Route route) {
        if ( routeDto == null ) {
            return null;
        }

        route.setId( routeDto.getId() );
        if ( routeDto.getCreatedTime() != null ) {
            route.setCreatedTime( routeDto.getCreatedTime() );
        }
        if ( routeDto.getUpdatedTime() != null ) {
            route.setUpdatedTime( routeDto.getUpdatedTime() );
        }
        if ( routeDto.getStartPoint() != null ) {
            route.setStartPoint( routeDto.getStartPoint() );
        }
        if ( routeDto.getEndPoint() != null ) {
            route.setEndPoint( routeDto.getEndPoint() );
        }
        route.setSumLength( routeDto.getSumLength() );
        if ( route.getRouteSections() != null ) {
            List<RouteSection> list = routeSectionDTOListToRouteSectionList( routeDto.getRouteSections() );
            if ( list != null ) {
                route.getRouteSections().clear();
                route.getRouteSections().addAll( list );
            }
        }
        else {
            List<RouteSection> list = routeSectionDTOListToRouteSectionList( routeDto.getRouteSections() );
            if ( list != null ) {
                route.setRouteSections( list );
            }
        }
        if ( routeDto.getDetails() != null ) {
            route.setDetails( routeDto.getDetails() );
        }

        return route;
    }

    protected RouteSection routeSectionDTOToRouteSection(RouteSectionDTO routeSectionDTO) {
        if ( routeSectionDTO == null ) {
            return null;
        }

        RouteSection routeSection = new RouteSection();

        routeSection.setId( routeSectionDTO.getId() );
        routeSection.setCreatedTime( routeSectionDTO.getCreatedTime() );
        routeSection.setUpdatedTime( routeSectionDTO.getUpdatedTime() );
        routeSection.setStartPointLeft( routeSectionDTO.getStartPointLeft() );
        routeSection.setEndPointLeft( routeSectionDTO.getEndPointLeft() );
        routeSection.setStartPointRight( routeSectionDTO.getStartPointRight() );
        routeSection.setEndPointRight( routeSectionDTO.getEndPointRight() );
        routeSection.setDirectionOfTraffic( routeSectionDTO.getDirectionOfTraffic() );
        routeSection.setType( routeSectionDTO.getType() );
        routeSection.setControlPointLeft( routeSectionDTO.getControlPointLeft() );
        routeSection.setControlPointRight( routeSectionDTO.getControlPointRight() );

        return routeSection;
    }

    protected List<RouteSection> routeSectionDTOListToRouteSectionList(List<RouteSectionDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<RouteSection> list1 = new ArrayList<RouteSection>( list.size() );
        for ( RouteSectionDTO routeSectionDTO : list ) {
            list1.add( routeSectionDTOToRouteSection( routeSectionDTO ) );
        }

        return list1;
    }

    protected RouteSectionDTO routeSectionToRouteSectionDTO(RouteSection routeSection) {
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

    protected List<RouteSectionDTO> routeSectionListToRouteSectionDTOList(List<RouteSection> list) {
        if ( list == null ) {
            return null;
        }

        List<RouteSectionDTO> list1 = new ArrayList<RouteSectionDTO>( list.size() );
        for ( RouteSection routeSection : list ) {
            list1.add( routeSectionToRouteSectionDTO( routeSection ) );
        }

        return list1;
    }
}
