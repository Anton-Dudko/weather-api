package com.example.weatherapi.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
@RequiredArgsConstructor
public class RapidWeatherApiConfig {

    private final RapidWeatherApiProperties rapidWeatherApiProperties;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(Duration.ofMillis(rapidWeatherApiProperties.getConnectTimeout()))
                .setReadTimeout(Duration.ofMillis(rapidWeatherApiProperties.getReadTimeout()))
                .defaultHeader("X-RapidAPI-Key", rapidWeatherApiProperties.getKey())
                .rootUri(rapidWeatherApiProperties.getHost())
                .build();
    }
}