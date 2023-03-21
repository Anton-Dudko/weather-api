package com.example.weatherapi.service;

import com.example.weatherapi.config.RapidWeatherApiProperties;
import com.example.weatherapi.config.RapidWeatherRequestProperties;
import com.example.weatherapi.mapper.WeatherMapperImple;
import com.example.weatherapi.model.dto.WeatherRootResponse;
import com.example.weatherapi.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherScheduler {

    private final WeatherMapperImple weatherMapper;
    private final RestTemplate restTemplate;
    private final RapidWeatherApiProperties rapidWeatherApiProperties;
    private final WeatherRepository weatherRepository;
    private final RapidWeatherRequestProperties rapidWeatherRequestProperties;


    @Scheduled(fixedRateString = "${rapid.fix-rate}")
    private void getWeather() {
        try {
            Optional.ofNullable(restTemplate.getForObject(rapidWeatherApiProperties.getHost(),
                            WeatherRootResponse.class,
                            rapidWeatherRequestProperties.getRequest()))
                    .map(weatherMapper::convertDtoToEntity)
                    .map(weatherRepository::save)
                    .orElseThrow(Exception::new);
        } catch (Exception exception) {
            log.error("Failed get response in rapid, exception message: {}", exception.getMessage());
        }
    }
}
// TODO mapper, validation, Exception in rest template,