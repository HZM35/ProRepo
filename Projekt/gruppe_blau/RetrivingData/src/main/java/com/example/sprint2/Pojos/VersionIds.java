
package com.example.sprint2.Pojos;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "brand_id",
    "model_id",
    "hardware_version",
    "firmware_version",
    "band_id"
})
@Generated("jsonschema2pojo")
public class VersionIds {

    @JsonProperty("brand_id")
    private String brandId;
    @JsonProperty("model_id")
    private String modelId;
    @JsonProperty("hardware_version")
    private String hardwareVersion;
    @JsonProperty("firmware_version")
    private String firmwareVersion;
    @JsonProperty("band_id")
    private String bandId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public VersionIds() {
    }

    public VersionIds(String brandId, String modelId, String hardwareVersion, String firmwareVersion, String bandId, Map<String, Object> additionalProperties) {
        this.brandId = brandId;
        this.modelId = modelId;
        this.hardwareVersion = hardwareVersion;
        this.firmwareVersion = firmwareVersion;
        this.bandId = bandId;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("brand_id")
    public String getBrandId() {
        return brandId;
    }

    @JsonProperty("brand_id")
    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    @JsonProperty("model_id")
    public String getModelId() {
        return modelId;
    }

    @JsonProperty("model_id")
    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    @JsonProperty("hardware_version")
    public String getHardwareVersion() {
        return hardwareVersion;
    }

    @JsonProperty("hardware_version")
    public void setHardwareVersion(String hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
    }

    @JsonProperty("firmware_version")
    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    @JsonProperty("firmware_version")
    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    @JsonProperty("band_id")
    public String getBandId() {
        return bandId;
    }

    @JsonProperty("band_id")
    public void setBandId(String bandId) {
        this.bandId = bandId;
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
        return "VersionIds{" +
                "brandId='" + brandId + '\'' +
                ", modelId='" + modelId + '\'' +
                ", hardwareVersion='" + hardwareVersion + '\'' +
                ", firmwareVersion='" + firmwareVersion + '\'' +
                ", bandId='" + bandId + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
