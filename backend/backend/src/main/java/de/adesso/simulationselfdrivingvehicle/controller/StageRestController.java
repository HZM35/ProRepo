package de.adesso.simulationselfdrivingvehicle.controller;


import de.adesso.simulationselfdrivingvehicle.entities.*;
import de.adesso.simulationselfdrivingvehicle.repositories.VehicleRepository;
import de.adesso.simulationselfdrivingvehicle.services.RouteService;
import de.adesso.simulationselfdrivingvehicle.services.VehicleService;
import de.adesso.simulationselfdrivingvehicle.entities.Stage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/stage")
public class StageRestController {

    private final RouteService routeService;
    private final VehicleService vehicleService;
    private final VehicleRepository vehicleRepository;

    public static long routeID = 0;
    private static long carID = 0;

    @PostMapping("/routeID/{routeId}")
    @ResponseStatus(HttpStatus.OK)
    public void setRouteID(@PathVariable long routeId) {
        routeID = routeId;
    }

    @PostMapping("/carID/{carId}")
    @ResponseStatus(HttpStatus.OK)
    public void setCarID(@PathVariable long carId) {
        carID = carId;
    }


    @PostMapping("/protocol")
    @ResponseStatus(HttpStatus.OK)
    public void setProtocol(@RequestBody List<Point> listPositionsVehicle) {

        Stage stage = new Stage();
        Vehicle vehicle = vehicleService.verifyVehicle(carID);
        stage.setVehicle(vehicle);
        stage.setPositions(listPositionsVehicle);
        Route route = routeService.verifyRoute(routeID);
        stage.setRoute(route);
        stage.saveProtocolForVehicle();
        Vehicle vehicleWithProtocol = stage.getVehicle();
        vehicleRepository.save(vehicleWithProtocol);

    }
}

