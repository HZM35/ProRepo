
package com.example.sprint2.Pojos;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "device_id",
    "application_ids",
    "dev_eui",
    "dev_addr"
})
@Generated("jsonschema2pojo")
public class EndDeviceIds {

    @JsonProperty("device_id")
    private String deviceId;
    @JsonProperty("application_ids")
    private ApplicationIds applicationIds;
    @JsonProperty("dev_eui")
    private String devEui;
    @JsonProperty("dev_addr")
    private String devAddr;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public EndDeviceIds() {
    }

    public EndDeviceIds(String deviceId, ApplicationIds applicationIds, String devEui, String devAddr, Map<String, Object> additionalProperties) {
        this.deviceId = deviceId;
        this.applicationIds = applicationIds;
        this.devEui = devEui;
        this.devAddr = devAddr;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("device_id")
    public String getDeviceId() {
        return deviceId;
    }

    @JsonProperty("device_id")
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @JsonProperty("application_ids")
    public ApplicationIds getApplicationIds() {
        return applicationIds;
    }

    @JsonProperty("application_ids")
    public void setApplicationIds(ApplicationIds applicationIds) {
        this.applicationIds = applicationIds;
    }

    @JsonProperty("dev_eui")
    public String getDevEui() {
        return devEui;
    }

    @JsonProperty("dev_eui")
    public void setDevEui(String devEui) {
        this.devEui = devEui;
    }

    @JsonProperty("dev_addr")
    public String getDevAddr() {
        return devAddr;
    }

    @JsonProperty("dev_addr")
    public void setDevAddr(String devAddr) {
        this.devAddr = devAddr;
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
        return "EndDeviceIds{" +
                "deviceId='" + deviceId + '\'' +
                ", applicationIds=" + applicationIds +
                ", devEui='" + devEui + '\'' +
                ", devAddr='" + devAddr + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
