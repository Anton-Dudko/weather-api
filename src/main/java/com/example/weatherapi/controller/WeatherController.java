package com.example.weatherapi.controller;

import com.example.weatherapi.model.WeatherInfo;
import com.example.weatherapi.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @RequestMapping("/current")
    public WeatherInfo getWeather(){
        return weatherService.getCurrentWeather();
    }
}
