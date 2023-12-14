
package com.example.sprint2.Pojos;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "latitude",
    "longitude",
    "altitude",
    "source"
})
@Generated("jsonschema2pojo")
public class Location {

    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("altitude")
    private Integer altitude;
    @JsonProperty("source")
    private String source;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Location() {
    }

    public Location(Double latitude, Double longitude, Integer altitude, String source, Map<String, Object> additionalProperties) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.source = source;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("latitude")
    public Double getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("longitude")
    public Double getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("altitude")
    public Integer getAltitude() {
        return altitude;
    }

    @JsonProperty("altitude")
    public void setAltitude(Integer altitude) {
        this.altitude = altitude;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Location{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", altitude=" + altitude +
                ", source='" + source + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
