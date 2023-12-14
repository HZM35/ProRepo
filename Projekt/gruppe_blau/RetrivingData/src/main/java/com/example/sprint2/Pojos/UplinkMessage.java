
package com.example.sprint2.Pojos;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "f_port",
    "f_cnt",
    "frm_payload",
    "decoded_payload",
    "rx_metadata",
    "settings",
    "received_at",
    "consumed_airtime",
    "locations",
    "version_ids",
    "network_ids"
})
@Generated("jsonschema2pojo")
public class UplinkMessage {

    @JsonProperty("f_port")
    private Integer fPort;
    @JsonProperty("f_cnt")
    private Integer fCnt;
    @JsonProperty("frm_payload")
    private String frmPayload;
    @JsonProperty("decoded_payload")
    private DecodedPayload decodedPayload;
    @JsonProperty("rx_metadata")
    private List<RxMetadatum> rxMetadata = null;
    @JsonProperty("settings")
    private Settings settings;
    @JsonProperty("received_at")
    private String receivedAt;
    @JsonProperty("consumed_airtime")
    private String consumedAirtime;
    @JsonProperty("locations")
    private Locations locations;
    @JsonProperty("version_ids")
    private VersionIds versionIds;
    @JsonProperty("network_ids")
    private NetworkIds networkIds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public UplinkMessage() {
    }

    public UplinkMessage(Integer fPort, Integer fCnt, String frmPayload, DecodedPayload decodedPayload, List<RxMetadatum> rxMetadata, Settings settings, String receivedAt, String consumedAirtime, Locations locations, VersionIds versionIds, NetworkIds networkIds, Map<String, Object> additionalProperties) {
        this.fPort = fPort;
        this.fCnt = fCnt;
        this.frmPayload = frmPayload;
        this.decodedPayload = decodedPayload;
        this.rxMetadata = rxMetadata;
        this.settings = settings;
        this.receivedAt = receivedAt;
        this.consumedAirtime = consumedAirtime;
        this.locations = locations;
        this.versionIds = versionIds;
        this.networkIds = networkIds;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("f_port")
    public Integer getfPort() {
        return fPort;
    }

    @JsonProperty("f_port")
    public void setfPort(Integer fPort) {
        this.fPort = fPort;
    }

    @JsonProperty("f_cnt")
    public Integer getfCnt() {
        return fCnt;
    }

    @JsonProperty("f_cnt")
    public void setfCnt(Integer fCnt) {
        this.fCnt = fCnt;
    }

    @JsonProperty("frm_payload")
    public String getFrmPayload() {
        return frmPayload;
    }

    @JsonProperty("frm_payload")
    public void setFrmPayload(String frmPayload) {
        this.frmPayload = frmPayload;
    }

    @JsonProperty("decoded_payload")
    public DecodedPayload getDecodedPayload() {
        return decodedPayload;
    }

    @JsonProperty("decoded_payload")
    public void setDecodedPayload(DecodedPayload decodedPayload) {
        this.decodedPayload = decodedPayload;
    }

    @JsonProperty("rx_metadata")
    public List<RxMetadatum> getRxMetadata() {
        return rxMetadata;
    }

    @JsonProperty("rx_metadata")
    public void setRxMetadata(List<RxMetadatum> rxMetadata) {
        this.rxMetadata = rxMetadata;
    }

    @JsonProperty("settings")
    public Settings getSettings() {
        return settings;
    }

    @JsonProperty("settings")
    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    @JsonProperty("received_at")
    public String getReceivedAt() {
        return receivedAt;
    }

    @JsonProperty("received_at")
    public void setReceivedAt(String receivedAt) {
        this.receivedAt = receivedAt;
    }

    @JsonProperty("consumed_airtime")
    public String getConsumedAirtime() {
        return consumedAirtime;
    }

    @JsonProperty("consumed_airtime")
    public void setConsumedAirtime(String consumedAirtime) {
        this.consumedAirtime = consumedAirtime;
    }

    @JsonProperty("locations")
    public Locations getLocations() {
        return locations;
    }

    @JsonProperty("locations")
    public void setLocations(Locations locations) {
        this.locations = locations;
    }

    @JsonProperty("version_ids")
    public VersionIds getVersionIds() {
        return versionIds;
    }

    @JsonProperty("version_ids")
    public void setVersionIds(VersionIds versionIds) {
        this.versionIds = versionIds;
    }

    @JsonProperty("network_ids")
    public NetworkIds getNetworkIds() {
        return networkIds;
    }

    @JsonProperty("network_ids")
    public void setNetworkIds(NetworkIds networkIds) {
        this.networkIds = networkIds;
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
        return "UplinkMessage{" +
                "fPort=" + fPort +
                ", fCnt=" + fCnt +
                ", frmPayload='" + frmPayload + '\'' +
                ", decodedPayload=" + decodedPayload +
                ", rxMetadata=" + rxMetadata +
                ", settings=" + settings +
                ", receivedAt='" + receivedAt + '\'' +
                ", consumedAirtime='" + consumedAirtime + '\'' +
                ", locations=" + locations +
                ", versionIds=" + versionIds +
                ", networkIds=" + networkIds +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
