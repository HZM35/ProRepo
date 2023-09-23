package de.adesso.simulationselfdrivingvehicle.controller;

import de.adesso.simulationselfdrivingvehicle.dto.XlsDTO;
import de.adesso.simulationselfdrivingvehicle.dto.VehicleDTO;
import de.adesso.simulationselfdrivingvehicle.services.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * This class is used to manage the Vehicles
 */

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/v1/vehicles")
public class VehicleRestController {
    private final VehicleService vehicleService;

    /**
     * Returns all Vehicles
     *
     * @return List of all vehicles
     */
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<VehicleDTO> getVehicles() {
        return this.vehicleService.findAll();
    }

    /**
     * Returns the vehicle you are looking for
     *
     * @param vehicleId the ID of the searched vehicle
     * @return the Vehicle you are looking for
     */
    @GetMapping(path = "/{vehicleId}")
    @ResponseStatus(HttpStatus.OK)
    public VehicleDTO getVehicle(@PathVariable long vehicleId) {
        return this.vehicleService.findById(vehicleId);
    }

    /**
     * @return All Protocols
     **/
    @GetMapping("/protocol")
    @ResponseStatus(HttpStatus.OK)
    public List<XlsDTO> getProtocols() {
        return this.vehicleService.getAllProtocols();
    }

    /**
     * Saves a vehicle.
     *
     * @param vehicleDTO an object of type VehicleDTO
     * @return the vehicle you saved
     */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public VehicleDTO saveVehicle(@RequestBody @Valid VehicleDTO vehicleDTO) {
        return this.vehicleService.save(vehicleDTO);
    }

    /**
     * updates a vehicle by id.
     *
     * @param vehicleId  the ID of the searched vehicle
     * @param vehicleDTO the vehicleDTO of Vehicle that containing new data
     * @return the vehicle you updated
     */
    @PostMapping(path = "/update/{vehicleId}")
    @ResponseStatus(value = HttpStatus.OK)
    public VehicleDTO updateVehicle(@PathVariable long vehicleId, @RequestBody @Valid VehicleDTO vehicleDTO) {
        return this.vehicleService.update(vehicleId, vehicleDTO);
    }


    /**
     * deletes a vehicle by id.
     *
     * @param vehicleId id of Vehicle
     * @return Message that the Vehicle was successfully deleted
     */
    @DeleteMapping(path = "/remove/{vehicleId}")
    @ResponseStatus(HttpStatus.OK)
    public String removeVehicle(@PathVariable long vehicleId) {
        return this.vehicleService.remove(vehicleId);
    }

    /**
     * deletes all Vehicles.
     *
     * @return Message that the Vehicles was successfully deleted
     */
    @DeleteMapping(path = "/removeAll")
    @ResponseStatus(HttpStatus.OK)
    public String removeAllVehicles() {
        return this.vehicleService.removeAll();
    }

}
