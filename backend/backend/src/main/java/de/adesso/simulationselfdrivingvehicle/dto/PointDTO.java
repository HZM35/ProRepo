package de.adesso.simulationselfdrivingvehicle.dto;

import lombok.*;

/**
 * Data transfer object to transfer the objects between client and server
 * Contains an x and y ,
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PointDTO {

    private double x;
    private double y;
}
