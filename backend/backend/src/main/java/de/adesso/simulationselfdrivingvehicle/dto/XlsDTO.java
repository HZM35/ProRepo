package de.adesso.simulationselfdrivingvehicle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class XlsDTO {
    private String vehicleModel;
    private String vehicleColor;
    private String vehicleMaximalSpeed;
    private String tripsDuration;
    private Long routeId;
    private String sumLength;
    private String startPoint;
    private String endPoint;
}
