package com.example.weatherapi.controller;

import com.example.weatherapi.model.WeatherInfo;
import com.example.weatherapi.model.dto.AverageWeatherRequest;
import com.example.weatherapi.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/current")
    public WeatherInfo getWeather() {
        return weatherService.getCurrentWeather();
    }

    @PostMapping("/average")
    public double getAvgWeather(@RequestBody AverageWeatherRequest averageWeatherRequest) {
        return weatherService.getAvgWeather(averageWeatherRequest);
    }
}
