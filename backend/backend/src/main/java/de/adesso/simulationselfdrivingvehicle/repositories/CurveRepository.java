package de.adesso.simulationselfdrivingvehicle.repositories;

import de.adesso.simulationselfdrivingvehicle.entities.Curve;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * the Repository for Route (Action and Contact with the DB)
 */
@Repository
public interface CurveRepository extends MongoRepository<Curve, Long> {
}
