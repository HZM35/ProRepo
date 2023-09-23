package de.adesso.simulationselfdrivingvehicle.services;


import de.adesso.simulationselfdrivingvehicle.dto.XlsDTO;
import de.adesso.simulationselfdrivingvehicle.dto.VehicleDTO;
import de.adesso.simulationselfdrivingvehicle.entities.Vehicle;
import de.adesso.simulationselfdrivingvehicle.error.VehicleNotFoundException;
import de.adesso.simulationselfdrivingvehicle.mapper.VehicleMapper;
import de.adesso.simulationselfdrivingvehicle.repositories.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * The layer between VehicleController and the Database
 */
@Service
@RequiredArgsConstructor
public class VehicleService {
    private final SequenceGeneratorService sequenceGeneratorService;
    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehiclemapper;

    /**
     * Returns all Vehicles
     *
     * @return List of all vehicles
     */

    public List<VehicleDTO> findAll() {
        return
                vehiclemapper.VEHICLE_DTOS(
                        vehicleRepository.findAll());
    }


    /**
     * Returns the vehicle you are looking for
     *
     * @param id the ID of the searched Vehicle
     * @return the Vehicle you are looking for
     */
    public VehicleDTO findById(long id) {
        Optional<Vehicle> vehicle = this.vehicleRepository.findById(id);

        if (vehicle.isEmpty()) {
            throw new VehicleNotFoundException("The Vehicle with id: " + id + " not found!");
        }
        return vehiclemapper.entityToDto(vehicle.get());
    }

    /**
     * Saves a vehicle.
     *
     * @param p_vehicle an object of type VehicleDTO
     * @return the vehicle you saved
     */
    public VehicleDTO save(VehicleDTO p_vehicle) {

        Vehicle vehicle = new Vehicle();
        vehicle.setColor(p_vehicle.getColor());
        vehicle.setModel(p_vehicle.getModel());
        vehicle.setMaximalSpeed(p_vehicle.getMaximalSpeed());

        vehicle.setCreatedTime(LocalDateTime.now());

        //auto generated Id
        vehicle.setId(sequenceGeneratorService.generateSequence());


        Vehicle v = vehicleRepository.save(vehicle);
        return vehiclemapper.entityToDto(v);

    }


    /**
     * updates a vehicle by id.
     * if the new vehicle contains empty attributes, they will not be null, but they will keep the old values
     *
     * @param p_id      the ID of the searched vehicle
     * @param p_vehicle the vehicle DTO containing new data
     * @return the vehicle you updated
     */
    public VehicleDTO update(long p_id, VehicleDTO p_vehicle) {

        Vehicle vehicle = verifyVehicle(p_id);
        p_vehicle.setUpdatedTime(LocalDateTime.now());
        p_vehicle.setCreatedTime(vehicle.getCreatedTime());
        p_vehicle.setId(vehicle.getId());
        vehicleRepository.save(vehiclemapper.dtoToEntity(p_vehicle));

        return p_vehicle;
    }

    public List<XlsDTO> getAllProtocols() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(0);

        List<XlsDTO> xlsDatei = new ArrayList<>();
        XlsDTO xlsLine;
        List<Vehicle> vehicles = this.vehicleRepository.findAll();
        for (Vehicle var : vehicles) {
            xlsLine = new XlsDTO();

            // Vehicle Detaills
            xlsLine.setVehicleColor(var.getColor());
            xlsLine.setVehicleModel(var.getModel());
            xlsLine.setVehicleMaximalSpeed(nf.format(var.getMaximalSpeed()));

            //the Vehicle has protocol
            if (var.getTripsNumber() > 0) {
                String tripsDuration = nf.format(var.getLastProtocol().getSumLengthRoute() / var.getMaximalSpeed());
                xlsLine.setTripsDuration(tripsDuration);

                //First Point of the list
                xlsLine.setStartPoint("( " + (int) var.getLastProtocol().getPoints().get(0).getX() + " , " + (int) var.getLastProtocol().getPoints().get(0).getY() + " )");
                //Last Point of the list

                xlsLine.setEndPoint("( " + (int) var.getLastProtocol().getPoints().get(var.getLastProtocol().getPoints().size() - 1).getX() + " , " + (int) var.getLastProtocol().getPoints().get(var.getLastProtocol().getPoints().size() - 1).getY() + " )");
                //Length of the Route
                xlsLine.setSumLength(nf.format(var.getLastProtocol().getSumLengthRoute()));

                //Route ID
                xlsLine.setRouteId(var.getLastProtocol().getRoute_id());
            }
            xlsDatei.add(xlsLine);
        }
        return xlsDatei;
    }

    /**
     * deletes a vehicle by id.
     *
     * @param id ID of Vehicle
     * @return Message that the vehicle successfully deleted
     */
    public String remove(long id) {
        Vehicle vehicle = verifyVehicle(id);
        vehicleRepository.delete(vehicle);
        return "Vehicle was successfully deleted";
    }

    /**
     * deletes all Vehicles.
     *
     * @return Message that Vehicles successfully deleted
     */
    public String removeAll() {
        vehicleRepository.deleteAll();
        return "Vehicles were successfully deleted";
    }

    /**
     * verifies if the Vehicle exists in the database
     *
     * @param p_id the ID of the searched vehicle
     * @return the existing Vehicle
     */

    public Vehicle verifyVehicle(long p_id) {

        return vehicleRepository.findById(p_id).orElseThrow(() ->
                new VehicleNotFoundException("Vehicle does not exist! ID: " + p_id));

    }
}
