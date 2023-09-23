package de.adesso.simulationselfdrivingvehicle.dto;

import de.adesso.simulationselfdrivingvehicle.entities.BaseElement;
import de.adesso.simulationselfdrivingvehicle.entities.Point;
import de.adesso.simulationselfdrivingvehicle.enums.RouteSectionType;
import lombok.Data;

/**
 * A DTO for the RouteSection entity
 */
@Data
public class RouteSectionDTO extends BaseElement {
    private final RouteSectionType type;
    private String directionOfTraffic;
    //left Side
    private final Point startPointLeft;
    private final Point endPointLeft;

    //Right Side
    private final Point startPointRight;
    private final Point endPointRight;

    // will be null when the RouteSection is a Straight
    private final Point controlPointLeft;
    private final Point controlPointRight;

}