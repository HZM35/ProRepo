package de.adesso.simulationselfdrivingvehicle.entities;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * a Stage Class
 */

@Data
@NoArgsConstructor
public class Stage {

    private Vehicle vehicle;
    private List<Point> positions;
    private Route route;

    public void saveProtocolForVehicle() {
        LocalTime time = LocalTime.now();
        SaveProtocolForEachVehicle(positions, time, vehicle, route);

    }
    private void SaveProtocolForEachVehicle(List<Point> positions, LocalTime time, Vehicle vehicle, Route route) {

        double LengthForEachPixel = route.getSumLength() / positions.size();
        double timeForEachPixelInSecond = (LengthForEachPixel / vehicle.getMaximalSpeed());
        int timeForEachPixelInMilliSecond = (int) (1000 * timeForEachPixelInSecond);
        Protocol protocol = new Protocol();
        protocol.setSumLengthRoute(route.getSumLength());
        protocol.setRoute_id(route.getId());
        for (Point p_current : positions) {
            protocol.setProtocolTime(p_current, time);
            time = time.plus(timeForEachPixelInMilliSecond, ChronoUnit.MILLIS);
        }
        vehicle.setProtocol(protocol);
    }

}
