package de.adesso.simulationselfdrivingvehicle.entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * A Curve Class .
 * Contains a left Start and End Point
 * Contains a right Start and End Point
 * Contains a right and left ProtocolPoint
 *
 */
@Document
@Data
@EqualsAndHashCode(callSuper = true)
public class Curve extends RouteSection  {

    public Curve() {
        super();
    }
}
