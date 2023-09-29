
package com.example.sprint2.Pojos;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lora"
})
@Generated("jsonschema2pojo")
public class DataRate {

    @JsonProperty("lora")
    private Lora lora;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public DataRate() {
    }

    public DataRate(Lora lora, Map<String, Object> additionalProperties) {
        this.lora = lora;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("lora")
    public Lora getLora() {
        return lora;
    }

    @JsonProperty("lora")
    public void setLora(Lora lora) {
        this.lora = lora;
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
        return "DataRate{" +
                "lora=" + lora +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
