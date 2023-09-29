
package com.example.sprint2.Pojos;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "humidity",
    "temperature"
})
@Generated("jsonschema2pojo")
public class DecodedPayload {

    @JsonProperty("humidity")
    private Integer humidity;
    @JsonProperty("temperature")
    private Double temperature;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public DecodedPayload() {
    }

    public DecodedPayload(Integer humidity, Double temperature, Map<String, Object> additionalProperties) {
        this.humidity = humidity;
        this.temperature = temperature;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("humidity")
    public Integer getHumidity() {
        return humidity;
    }

    @JsonProperty("humidity")
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    @JsonProperty("temperature")
    public Double getTemperature() {
        return temperature;
    }

    @JsonProperty("temperature")
    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
