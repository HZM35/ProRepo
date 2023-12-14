
package com.example.sprint2.Pojos;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "end_device_ids",
    "received_at",
    "uplink_message"
})
@Generated("jsonschema2pojo")
public class Result {

    @JsonProperty("end_device_ids")
    private EndDeviceIds endDeviceIds;
    @JsonProperty("received_at")
    private String receivedAt;
    @JsonProperty("uplink_message")
    private UplinkMessage uplinkMessage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Result() {
    }

    public Result(EndDeviceIds endDeviceIds, String receivedAt, UplinkMessage uplinkMessage, Map<String, Object> additionalProperties) {
        this.endDeviceIds = endDeviceIds;
        this.receivedAt = receivedAt;
        this.uplinkMessage = uplinkMessage;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("end_device_ids")
    public EndDeviceIds getEndDeviceIds() {
        return endDeviceIds;
    }

    @JsonProperty("end_device_ids")
    public void setEndDeviceIds(EndDeviceIds endDeviceIds) {
        this.endDeviceIds = endDeviceIds;
    }

    @JsonProperty("received_at")
    public String getReceivedAt() {
        return receivedAt;
    }

    @JsonProperty("received_at")
    public void setReceivedAt(String receivedAt) {
        this.receivedAt = receivedAt;
    }

    @JsonProperty("uplink_message")
    public UplinkMessage getUplinkMessage() {
        return uplinkMessage;
    }

    @JsonProperty("uplink_message")
    public void setUplinkMessage(UplinkMessage uplinkMessage) {
        this.uplinkMessage = uplinkMessage;
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
        return "Result{" +
                "endDeviceIds=" + endDeviceIds +
                ", receivedAt='" + receivedAt + '\'' +
                ", uplinkMessage=" + uplinkMessage +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
