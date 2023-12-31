
package com.example.sprint2.Pojos;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "result"
})
@Generated("jsonschema2pojo")
public class SensorPojo {

    @JsonProperty("result")
    private Result result;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public SensorPojo() {
    }

    public SensorPojo(Result result, Map<String, Object> additionalProperties) {
        this.result = result;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("result")
    public Result getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(Result result) {
        this.result = result;
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
        return "SensorPojo{" +
                "result=" + result +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
