package de.adesso.simulationselfdrivingvehicle.error;

/**
 * RouteNotFoundException can be thrown if the Route we are looking for is not found .
 */
public class RouteNotFoundException extends RuntimeException {
    public RouteNotFoundException(String message) {
        super(message);
    }
}
