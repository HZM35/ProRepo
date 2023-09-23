package de.adesso.simulationselfdrivingvehicle.mapper;

import de.adesso.simulationselfdrivingvehicle.dto.VehicleDTO;
import de.adesso.simulationselfdrivingvehicle.entities.Protocol;
import de.adesso.simulationselfdrivingvehicle.entities.Vehicle;
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
public class VehicleMapperImpl implements VehicleMapper {

    @Override
    public List<VehicleDTO> VEHICLE_DTOS(List<Vehicle> vehicles) {
        if ( vehicles == null ) {
            return null;
        }

        List<VehicleDTO> list = new ArrayList<VehicleDTO>( vehicles.size() );
        for ( Vehicle vehicle : vehicles ) {
            list.add( entityToDto( vehicle ) );
        }

        return list;
    }

    @Override
    public VehicleDTO entityToDto(Vehicle vehicle) {
        if ( vehicle == null ) {
            return null;
        }

        VehicleDTO vehicleDTO = new VehicleDTO();

        vehicleDTO.setId( vehicle.getId() );
        vehicleDTO.setCreatedTime( vehicle.getCreatedTime() );
        vehicleDTO.setUpdatedTime( vehicle.getUpdatedTime() );
        vehicleDTO.setColor( vehicle.getColor() );
        vehicleDTO.setModel( vehicle.getModel() );
        vehicleDTO.setMaximalSpeed( vehicle.getMaximalSpeed() );
        List<Protocol> list = vehicle.getProtocolList();
        if ( list != null ) {
            vehicleDTO.setProtocolList( new ArrayList<Protocol>( list ) );
        }

        return vehicleDTO;
    }

    @Override
    public Vehicle dtoToEntity(VehicleDTO vehicleDTO) {
        if ( vehicleDTO == null ) {
            return null;
        }

        Vehicle vehicle = new Vehicle();

        vehicle.setId( vehicleDTO.getId() );
        vehicle.setCreatedTime( vehicleDTO.getCreatedTime() );
        vehicle.setUpdatedTime( vehicleDTO.getUpdatedTime() );
        List<Protocol> list = vehicleDTO.getProtocolList();
        if ( list != null ) {
            vehicle.setProtocolList( new ArrayList<Protocol>( list ) );
        }
        vehicle.setColor( vehicleDTO.getColor() );
        vehicle.setModel( vehicleDTO.getModel() );
        if ( vehicleDTO.getMaximalSpeed() != null ) {
            vehicle.setMaximalSpeed( vehicleDTO.getMaximalSpeed() );
        }

        return vehicle;
    }
}
