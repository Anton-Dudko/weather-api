package com.example.weatherapi.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rapid")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RapidWeatherApiProperties {

    private String host;
    private int connectTimeout;
    private int readTimeout;
    private String key;

}
