package com.silence.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "value",
        "unrestricted_value",
        "data"
})
public class Address {

    @JsonProperty("value")
    private String value;
    @JsonProperty("unrestricted_value")
    private String unrestrictedValue;
    @JsonProperty("data")
    private AddressData data;

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonProperty("unrestricted_value")
    public String getUnrestrictedValue() {
        return unrestrictedValue;
    }

    @JsonProperty("unrestricted_value")
    public void setUnrestrictedValue(String unrestrictedValue) {
        this.unrestrictedValue = unrestrictedValue;
    }

    @JsonProperty("data")
    public AddressData getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(AddressData data) {
        this.data = data;
    }

}
