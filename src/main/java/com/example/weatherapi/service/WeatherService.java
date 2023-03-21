package com.example.weatherapi.service;

import com.example.weatherapi.model.WeatherInfo;
import com.example.weatherapi.model.dto.AverageWeatherRequest;
import com.example.weatherapi.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;

    public WeatherInfo getCurrentWeather() {
        return weatherRepository.findFirstByOrderByLocation_LocaltimeStrDesc();
    }

    private final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public double getAvgWeather(AverageWeatherRequest averageWeatherRequest) {
        return weatherRepository.averageTemperature(LocalDate.parse(averageWeatherRequest.getFrom(), df),
                LocalDate.parse(averageWeatherRequest.getTo(), df));
    }
}
