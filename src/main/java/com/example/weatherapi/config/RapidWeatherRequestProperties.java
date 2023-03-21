package com.example.weatherapi.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "rapid")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RapidWeatherRequestProperties {
   private Map<String, String> request;
}
