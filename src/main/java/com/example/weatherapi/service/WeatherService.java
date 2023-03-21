package com.example.weatherapi.service;

import com.example.weatherapi.model.WeatherInfo;
import com.example.weatherapi.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;

    public WeatherInfo getCurrentWeather(){
        return weatherRepository.findFirstByOrderByLocation_LocaltimeStrDesc();
    }

    public Double getAvgWeather(LocalDateTime from, LocalDateTime to){
        return weatherRepository.averageTemperature(from, to);
    }
}
