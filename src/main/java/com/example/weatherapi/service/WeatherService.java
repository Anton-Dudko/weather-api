package com.example.weatherapi.service;

import com.example.weatherapi.model.WeatherInfo;
import com.example.weatherapi.model.dto.AverageWeatherRequest;
import com.example.weatherapi.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;

    public WeatherInfo getCurrentWeather() {
        return weatherRepository.findFirstByOrderByLocation_LocaltimeStrDesc();
    }

    public double getAvgWeather(AverageWeatherRequest averageWeatherRequest) {
        return weatherRepository.averageTemperature(averageWeatherRequest.getFrom(),
                averageWeatherRequest.getTo());
    }
}
