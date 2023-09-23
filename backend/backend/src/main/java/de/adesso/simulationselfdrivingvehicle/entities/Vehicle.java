package de.adesso.simulationselfdrivingvehicle.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


/**
 * a  Vehicle with maximalSpeed , model and other attributes
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle extends BaseElement {


    private String color;

    private String model;

    private double maximalSpeed;

    private List<Protocol> protocolList = new ArrayList<>();

    private Point currentPosition;


    private int tripsNumber;

    private int lastProtocolNumber = tripsNumber - 1;

    public void setProtocol(Protocol tempProtocol) {

        protocolList.add(tempProtocol);
        tripsNumber = protocolList.size();
        lastProtocolNumber = tripsNumber - 1;
    }

    public void setProtocolList(List<Protocol> temp_protocolList) {
        protocolList = temp_protocolList;
        tripsNumber = protocolList.size();
        lastProtocolNumber = tripsNumber - 1;
    }

    public Protocol getLastProtocol() {
        return (lastProtocolNumber >= 0)
                ? protocolList.get(lastProtocolNumber)
                : null;
    }
}
