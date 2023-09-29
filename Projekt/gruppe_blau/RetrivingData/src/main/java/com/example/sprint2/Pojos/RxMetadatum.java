
package com.example.sprint2.Pojos;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "gateway_ids",
    "time",
    "timestamp",
    "rssi",
    "channel_rssi",
    "snr",
    "location",
    "channel_index"
})
@Generated("jsonschema2pojo")
public class RxMetadatum {

    @JsonProperty("gateway_ids")
    private GatewayIds gatewayIds;
    @JsonProperty("time")
    private String time;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("rssi")
    private Integer rssi;
    @JsonProperty("channel_rssi")
    private Integer channelRssi;
    @JsonProperty("snr")
    private Double snr;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("channel_index")
    private Integer channelIndex;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public RxMetadatum() {
    }

    public RxMetadatum(GatewayIds gatewayIds, String time, String timestamp, Integer rssi, Integer channelRssi, Double snr, Location location, Integer channelIndex, Map<String, Object> additionalProperties) {
        this.gatewayIds = gatewayIds;
        this.time = time;
        this.timestamp = timestamp;
        this.rssi = rssi;
        this.channelRssi = channelRssi;
        this.snr = snr;
        this.location = location;
        this.channelIndex = channelIndex;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("gateway_ids")
    public GatewayIds getGatewayIds() {
        return gatewayIds;
    }

    @JsonProperty("gateway_ids")
    public void setGatewayIds(GatewayIds gatewayIds) {
        this.gatewayIds = gatewayIds;
    }

    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("rssi")
    public Integer getRssi() {
        return rssi;
    }

    @JsonProperty("rssi")
    public void setRssi(Integer rssi) {
        this.rssi = rssi;
    }

    @JsonProperty("channel_rssi")
    public Integer getChannelRssi() {
        return channelRssi;
    }

    @JsonProperty("channel_rssi")
    public void setChannelRssi(Integer channelRssi) {
        this.channelRssi = channelRssi;
    }

    @JsonProperty("snr")
    public Double getSnr() {
        return snr;
    }

    @JsonProperty("snr")
    public void setSnr(Double snr) {
        this.snr = snr;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("channel_index")
    public Integer getChannelIndex() {
        return channelIndex;
    }

    @JsonProperty("channel_index")
    public void setChannelIndex(Integer channelIndex) {
        this.channelIndex = channelIndex;
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
        return "RxMetadatum{" +
                "gatewayIds=" + gatewayIds +
                ", time='" + time + '\'' +
                ", timestamp=" + timestamp +
                ", rssi=" + rssi +
                ", channelRssi=" + channelRssi +
                ", snr=" + snr +
                ", location=" + location +
                ", channelIndex=" + channelIndex +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
