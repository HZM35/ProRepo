
package com.example.sprint2.Pojos;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "data_rate",
    "coding_rate",
    "frequency",
    "timestamp",
    "time"
})
@Generated("jsonschema2pojo")
public class Settings {

    @JsonProperty("data_rate")
    private DataRate dataRate;
    @JsonProperty("coding_rate")
    private String codingRate;
    @JsonProperty("frequency")
    private String frequency;
    @JsonProperty("timestamp")
    private Long timestamp;
    @JsonProperty("time")
    private String time;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Settings() {
    }

    public Settings(DataRate dataRate, String codingRate, String frequency, Long timestamp, String time, Map<String, Object> additionalProperties) {
        this.dataRate = dataRate;
        this.codingRate = codingRate;
        this.frequency = frequency;
        this.timestamp = timestamp;
        this.time = time;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("data_rate")
    public DataRate getDataRate() {
        return dataRate;
    }

    @JsonProperty("data_rate")
    public void setDataRate(DataRate dataRate) {
        this.dataRate = dataRate;
    }

    @JsonProperty("coding_rate")
    public String getCodingRate() {
        return codingRate;
    }

    @JsonProperty("coding_rate")
    public void setCodingRate(String codingRate) {
        this.codingRate = codingRate;
    }

    @JsonProperty("frequency")
    public String getFrequency() {
        return frequency;
    }

    @JsonProperty("frequency")
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    @JsonProperty("timestamp")
    public Long getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
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
        return "Settings{" +
                "dataRate=" + dataRate +
                ", codingRate='" + codingRate + '\'' +
                ", frequency='" + frequency + '\'' +
                ", timestamp=" + timestamp +
                ", time='" + time + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
