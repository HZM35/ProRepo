package de.adesso.simulationselfdrivingvehicle.repositories;


import de.adesso.simulationselfdrivingvehicle.entities.Route;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * the Repository for Route  (Action and Contact with the DB)
 */


@Repository
public interface RouteRepository extends MongoRepository<Route, Long> {
}
