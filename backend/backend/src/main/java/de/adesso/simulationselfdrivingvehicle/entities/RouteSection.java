package de.adesso.simulationselfdrivingvehicle.entities;

import de.adesso.simulationselfdrivingvehicle.enums.RouteSectionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Abstract Class RouteSection for different RouteSection
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RouteSection extends BaseElement {


    /*
     *  endPointLeft        *  endPointRight
     *                      *
     *  startPointLeft      *  startPointRight
     */
    private Point startPointLeft;
    private Point endPointLeft;


    private Point startPointRight;
    private Point endPointRight;

    private String directionOfTraffic;
    private RouteSectionType type;

    // will be null if the RouteSection is a Straight
    private   Point controlPointLeft;
    private   Point controlPointRight;


}
