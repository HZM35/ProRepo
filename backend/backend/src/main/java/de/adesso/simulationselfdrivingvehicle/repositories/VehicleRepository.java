package de.adesso.simulationselfdrivingvehicle.repositories;

import de.adesso.simulationselfdrivingvehicle.entities.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * the Repository for Vehicle (Action and Contact with the DB)
 */
@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, Long> {
}
