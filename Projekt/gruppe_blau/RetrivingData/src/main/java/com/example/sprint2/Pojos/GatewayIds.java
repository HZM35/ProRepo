
package com.example.sprint2.Pojos;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "gateway_id",
    "eui"
})
@Generated("jsonschema2pojo")
public class GatewayIds {

    @JsonProperty("gateway_id")
    private String gatewayId;
    @JsonProperty("eui")
    private String eui;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public GatewayIds() {
    }

    public GatewayIds(String gatewayId, String eui, Map<String, Object> additionalProperties) {
        this.gatewayId = gatewayId;
        this.eui = eui;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("gateway_id")
    public String getGatewayId() {
        return gatewayId;
    }

    @JsonProperty("gateway_id")
    public void setGatewayId(String gatewayId) {
        this.gatewayId = gatewayId;
    }

    @JsonProperty("eui")
    public String getEui() {
        return eui;
    }

    @JsonProperty("eui")
    public void setEui(String eui) {
        this.eui = eui;
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
        return "GatewayIds{" +
                "gatewayId='" + gatewayId + '\'' +
                ", eui='" + eui + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
