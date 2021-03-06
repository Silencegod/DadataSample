package com.silence.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "type",
        "code",
        "full",
        "short"
})
public class Opf {

    @JsonProperty("type")
    private String type;
    @JsonProperty("code")
    private String code;
    @JsonProperty("full")
    private String full;
    @JsonProperty("short")
    private String _short;

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("full")
    public String getFull() {
        return full;
    }

    @JsonProperty("full")
    public void setFull(String full) {
        this.full = full;
    }

    @JsonProperty("short")
    public String getShort() {
        return _short;
    }

    @JsonProperty("short")
    public void setShort(String _short) {
        this._short = _short;
    }

}
