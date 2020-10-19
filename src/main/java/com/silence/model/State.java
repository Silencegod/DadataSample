package com.silence.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.silence.json.TimestampDeserializer;

import java.time.LocalDate;

@JsonPropertyOrder({
        "status",
        "actuality_date",
        "registration_date",
        "liquidation_date"
})
public class State {

    @JsonProperty("status")
    private String status;
    @JsonProperty("actuality_date")
    @JsonDeserialize(using = TimestampDeserializer.class)
    private LocalDate actualityDate;
    @JsonProperty("registration_date")
    @JsonDeserialize(using = TimestampDeserializer.class)
    private LocalDate registrationDate;
    @JsonProperty("liquidation_date")
    @JsonDeserialize(using = TimestampDeserializer.class)
    private LocalDate liquidationDate;

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("actuality_date")
    public LocalDate getActualityDate() {
        return actualityDate;
    }

    @JsonProperty("actuality_date")
    public void setActualityDate(LocalDate actualityDate) {
        this.actualityDate = actualityDate;
    }

    @JsonProperty("registration_date")
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    @JsonProperty("registration_date")
    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    @JsonProperty("liquidation_date")
    public LocalDate getLiquidationDate() {
        return liquidationDate;
    }

    @JsonProperty("liquidation_date")
    public void setLiquidationDate(LocalDate liquidationDate) {
        this.liquidationDate = liquidationDate;
    }

}
