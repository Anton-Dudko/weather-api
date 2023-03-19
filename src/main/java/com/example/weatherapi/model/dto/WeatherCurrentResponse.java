package com.example.weatherapi.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherCurrentResponse {
    @JsonProperty("temp_c")
    private double temperature;
    @JsonProperty("wind_kph")
    private double windSpeed;
    @JsonProperty("pressure_mb")
    private double pressureMb;

    private double humidity;

    private WeatherConditionResponse condition;

}
