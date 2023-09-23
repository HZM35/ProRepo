package de.adesso.simulationselfdrivingvehicle.controller;

import de.adesso.simulationselfdrivingvehicle.dto.RouteDTO;
import de.adesso.simulationselfdrivingvehicle.services.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * This class is used to manage the Routes
 */
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/v1/routes")
public class RouteRestController {


    private final RouteService routeService;

    /**
     * Returns all Routes
     *
     * @return List of all Routes
     */
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<RouteDTO> getRoutes() {
        return this.routeService.findAll();
    }

    /**
     * Returns the Route you are looking for with the id equals routeId
     *
     * @param routeId the ID of the searched route
     * @return the route you are looking for
     */
    @GetMapping(path = "/{routeId}")
    @ResponseStatus(HttpStatus.OK)
    public RouteDTO getRoute(@PathVariable long routeId) {
        return this.routeService.findById(routeId);
    }

    /**
     * Saves a route.
     *
     * @param p_route an object of type RouteDTO
     * @return the Route you saved
     */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public RouteDTO saveRoute(@RequestBody RouteDTO p_route) {

        return this.routeService.save(p_route);
    }

    /**
     * updates a Route by id.
     * if the new route contains empty attributes, they will not be null, but they will keep the old value
     *
     * @param routeId  the ID of the searched route
     * @param newRoute the route containing new data
     * @return the Route was you updated
     */
    @PostMapping(path = "/update/{routeId}")
    @ResponseStatus(HttpStatus.OK)
    public RouteDTO updateRoute(@PathVariable long routeId, @RequestBody RouteDTO newRoute) {
        return this.routeService.update(routeId, newRoute);
    }


    /**
     * deletes a route by id.
     *
     * @param routeId ID of Route
     * @return Message that the Route was successfully deleted
     */
    @DeleteMapping(path = "/remove/{routeId}")
    @ResponseStatus(HttpStatus.OK)
    public String removeRoute(@PathVariable long routeId) {
        return this.routeService.remove(routeId);
    }

    /**
     * deletes all Routes.
     *
     * @return Message that all Routes was successfully deleted
     */
    @DeleteMapping(path = "/removeAll")
    @ResponseStatus(HttpStatus.OK)
    public String removeAllVehicles() {
        return this.routeService.removeAll();
    }

}
