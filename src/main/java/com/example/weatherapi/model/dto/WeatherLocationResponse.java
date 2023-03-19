package com.example.weatherapi.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherLocationResponse {

    private String name;
    private String region;
    private String country;
    private double lat;
    private double lon;
    @JsonProperty("tz_id")
    private String timeZoneId;
    @JsonProperty("localtime_epoch")
    private Long localtimeEpoch;
    private String localtime;
}
