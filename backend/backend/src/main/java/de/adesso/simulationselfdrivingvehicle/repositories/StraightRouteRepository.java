package de.adesso.simulationselfdrivingvehicle.repositories;

import de.adesso.simulationselfdrivingvehicle.entities.StraightRoute;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * the Repository for Straight  (Action and Contact with the DB)
 */
@Repository
public interface StraightRouteRepository extends MongoRepository<StraightRoute, Long> {
}
