package com.example.weatherapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AverageWeatherRequest {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String from;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String to;
}
