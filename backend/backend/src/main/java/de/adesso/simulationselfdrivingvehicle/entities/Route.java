package de.adesso.simulationselfdrivingvehicle.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * A Route Class.
 */

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Route extends BaseElement {


    private Point startPoint;
    private Point endPoint;

    // the complete Length of the Route
    private double sumLength;
    private List<RouteSection> routeSections = new ArrayList<>();

    // For Example : {Die Strecke besteht aus nur geraden Streckenabschnitten}
    private String details;

    public void setRouteSection(RouteSection routesection) {
        routeSections.add(routesection);

    }


}
