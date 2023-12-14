
package com.example.sprint2.Pojos;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "application_id"
})
@Generated("jsonschema2pojo")
public class ApplicationIds {

    @JsonProperty("application_id")
    private String applicationId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public ApplicationIds() {
    }

    public ApplicationIds(String applicationId, Map<String, Object> additionalProperties) {
        this.applicationId = applicationId;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("application_id")
    public String getApplicationId() {
        return applicationId;
    }

    @JsonProperty("application_id")
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
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
        return "ApplicationIds{" +
                "applicationId='" + applicationId + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
