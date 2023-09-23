package de.adesso.simulationselfdrivingvehicle.dto;

import de.adesso.simulationselfdrivingvehicle.entities.BaseElement;
import de.adesso.simulationselfdrivingvehicle.entities.Protocol;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the Vehicle
 */
@Getter
@Setter
public class VehicleDTO extends BaseElement {

    @NotNull(message = "Color must not be null")
    @NotEmpty(message = "Color must not be empty")
    private String color;

    @NotNull(message = "Model must not be null")
    @NotEmpty(message = "Model must not be empty")
    private String model;

    @NotNull(message = "Maximal Speed must not be null")
    @Min(10)
    @Max(300)
    private Double maximalSpeed;


    /**
     * Control variables ,to know if our Vehicle Data updated was
     */
    private boolean isColor;
    private boolean isModel;
    private boolean isMaximalSpeed;

    private List<Protocol> protocolList = new ArrayList<>();



    public void setColor(String color) {
        this.color = color;
        isColor = true;
    }

    public void setModel(String model) {
        this.model = model;
        isModel = true;
    }

    public void setMaximalSpeed(Double maximalSpeed) {
        this.maximalSpeed = maximalSpeed;
        isMaximalSpeed = true;
    }



}