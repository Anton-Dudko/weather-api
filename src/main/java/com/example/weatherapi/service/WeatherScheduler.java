package com.example.weatherapi.service;

import com.example.weatherapi.config.RapidWeatherApiProperties;
import com.example.weatherapi.config.RapidWeatherRequestProperties;
import com.example.weatherapi.mapper.WeatherMapper;
import com.example.weatherapi.model.WeatherInfo;
import com.example.weatherapi.model.dto.WeatherRootResponse;
import com.example.weatherapi.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherScheduler {

    private final WeatherMapper weatherMapper1;
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
                    .map(weatherMapper1::convertDtoToEntity)
                    .filter(weatherInfo -> Objects.isNull(validWeatherInfoSave(weatherInfo)))
                    .map(weatherRepository::save)
                    .orElseThrow(()-> new Exception("Weather info is already exist"));
        } catch (Exception exception) {
            log.error("Error message in getWeather() {}", exception.getMessage());
        }
    }

    private WeatherInfo validWeatherInfoSave(WeatherInfo weatherInfo) {
        return weatherRepository.findByLocation_LocaltimeStr(weatherInfo.getLocation().getLocaltimeStr());
    }
}
// TODO validation, Exception in rest template