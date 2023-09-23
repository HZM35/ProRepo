package de.adesso.simulationselfdrivingvehicle.error;

/**
 * VehicleNotFoundException can be thrown if the vehicle we are looking for is not found .
 */
public class VehicleNotFoundException extends RuntimeException {
    public VehicleNotFoundException(String message) {
        super(message);
    }
}
