package com.example.weatherapi.service;

import com.example.weatherapi.config.RapidWeatherApiProperties;
import com.example.weatherapi.mapper.WeatherMapperImple;
import com.example.weatherapi.model.WeatherInfo;
import com.example.weatherapi.model.dto.WeatherRootResponse;
import com.example.weatherapi.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherSheduler {

    private final WeatherMapperImple weatherMapper;
    private final RestTemplate restTemplate;
    private final RapidWeatherApiProperties rapidWeatherApiProperties;
    private final WeatherRepository weatherRepository;


    @Scheduled(fixedRate = 15000)
    private void getWeather() {
        Map<String, String> params = new HashMap<>();
        params.put("name", "Minsk");

        WeatherRootResponse forObject = restTemplate.getForObject(rapidWeatherApiProperties.getHost(), WeatherRootResponse.class, params);


        WeatherInfo weatherInfo = weatherMapper.convertDtoToEntity(forObject);
        log.info(weatherInfo.toString());

        log.info(forObject.toString());

        weatherRepository.save(weatherInfo);

    }
}
