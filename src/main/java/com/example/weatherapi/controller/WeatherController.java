package com.example.weatherapi.controller;

import com.example.weatherapi.model.WeatherInfo;
import com.example.weatherapi.model.dto.AverageWeatherRequest;
import com.example.weatherapi.service.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;
    private final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd H:mm");

    @GetMapping("/current")
    public WeatherInfo getWeather(){
        return weatherService.getCurrentWeather();
    }

    @PostMapping("/average")
    public Double getAvgWeather(@RequestBody AverageWeatherRequest averageWeatherRequest){
       // log.info(averageWeatherRequest.getFrom().toString());
        return weatherService.getAvgWeather(LocalDateTime.parse(averageWeatherRequest.getFrom(), df)
                , LocalDateTime.parse(averageWeatherRequest.getTo(), df));
    }
}
