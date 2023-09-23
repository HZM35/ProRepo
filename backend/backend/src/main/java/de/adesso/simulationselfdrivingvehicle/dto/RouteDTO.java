package de.adesso.simulationselfdrivingvehicle.dto;

import de.adesso.simulationselfdrivingvehicle.entities.BaseElement;
import de.adesso.simulationselfdrivingvehicle.entities.Point;
import lombok.Data;

import java.util.List;

/**
 * A DTO for the Route entity
 */
@Data
public class RouteDTO extends BaseElement {
    private  Point startPoint;
    private  Point endPoint;

    // the complete Length of the Route
    private  double sumLength;
    private  List<RouteSectionDTO> routeSections;

    // For Example : {Die Strecke besteht aus nur geraden Streckenabschnitten}
    private String details;



}