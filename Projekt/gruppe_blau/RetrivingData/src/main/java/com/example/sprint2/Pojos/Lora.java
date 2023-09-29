
package com.example.sprint2.Pojos;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bandwidth",
    "spreading_factor"
})
@Generated("jsonschema2pojo")
public class Lora {

    @JsonProperty("bandwidth")
    private Integer bandwidth;
    @JsonProperty("spreading_factor")
    private Integer spreadingFactor;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Lora() {
    }

    public Lora(Integer bandwidth, Integer spreadingFactor, Map<String, Object> additionalProperties) {
        this.bandwidth = bandwidth;
        this.spreadingFactor = spreadingFactor;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("bandwidth")
    public Integer getBandwidth() {
        return bandwidth;
    }

    @JsonProperty("bandwidth")
    public void setBandwidth(Integer bandwidth) {
        this.bandwidth = bandwidth;
    }

    @JsonProperty("spreading_factor")
    public Integer getSpreadingFactor() {
        return spreadingFactor;
    }

    @JsonProperty("spreading_factor")
    public void setSpreadingFactor(Integer spreadingFactor) {
        this.spreadingFactor = spreadingFactor;
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
        return "Lora{" +
                "bandwidth=" + bandwidth +
                ", spreadingFactor=" + spreadingFactor +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
