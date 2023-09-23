package de.adesso.simulationselfdrivingvehicle.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * a Straight Class with a fixed length and width 200M
 */

@Document
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class StraightRoute extends RouteSection {
}
