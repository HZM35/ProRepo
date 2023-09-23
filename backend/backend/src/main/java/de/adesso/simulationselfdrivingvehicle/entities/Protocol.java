package de.adesso.simulationselfdrivingvehicle.entities;

import lombok.Data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
/**
 * a Protocol Class
 */


@Data
public class Protocol {
    List<Point> points;
    List<LocalTime> times;

    private double sumLengthRoute;

    private Long route_id;

    public Protocol() {
        points = new ArrayList<>();
        times = new ArrayList<>();
        sumLengthRoute = 0;
    }

    public void setProtocolTime(Point point, LocalTime time) {
        points.add(point);
        times.add(time);
    }


}
