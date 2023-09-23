package de.adesso.simulationselfdrivingvehicle.mapper;

import de.adesso.simulationselfdrivingvehicle.entities.Vehicle;
import de.adesso.simulationselfdrivingvehicle.dto.VehicleDTO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * the Mapper for Vehicle Class
 */


@Mapper (componentModel = "spring")
public interface VehicleMapper {


    List<VehicleDTO> VEHICLE_DTOS(List<Vehicle> vehicles);


    VehicleDTO entityToDto(Vehicle vehicle);

    Vehicle dtoToEntity(VehicleDTO vehicleDTO);

}
