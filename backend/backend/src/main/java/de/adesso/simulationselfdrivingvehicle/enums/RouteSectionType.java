package de.adesso.simulationselfdrivingvehicle.enums;

/**
 * an Enum with two Properties Curve and Straight
 */
public enum RouteSectionType {

    Curve("Curve"), Straight("Straight");

    private String text;

    RouteSectionType(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

}
