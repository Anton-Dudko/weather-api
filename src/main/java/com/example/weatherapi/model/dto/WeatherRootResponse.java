package com.example.weatherapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherRootResponse {
    private WeatherLocationResponse location;
    private WeatherCurrentResponse current;
}
