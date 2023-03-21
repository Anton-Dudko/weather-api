package com.example.weatherapi.mapper;

import com.example.weatherapi.model.Location;
import com.example.weatherapi.model.WeatherInfo;
import com.example.weatherapi.model.dto.WeatherLocationResponse;
import com.example.weatherapi.model.dto.WeatherRootResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Component
@Slf4j
public class WeatherMapperImple  {

    private final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd H:mm");


    public WeatherInfo convertDtoToEntity(WeatherRootResponse weatherRootResponse) {
        if (weatherRootResponse == null) {
            return null;
        }
        WeatherInfo weatherInfo = new WeatherInfo();

        weatherInfo.setTemperature(weatherRootResponse.getCurrent().getTemperature());
        weatherInfo.setWindSpeed(weatherRootResponse.getCurrent().getWindSpeed());
        weatherInfo.setPressureMb(weatherRootResponse.getCurrent().getPressureMb());
        weatherInfo.setHumidity(weatherRootResponse.getCurrent().getHumidity());
        weatherInfo.setWeatherConditions(weatherRootResponse.getCurrent().getCondition().getText());
        weatherInfo.setLocation(weatherLocationResponseToLocation(weatherRootResponse.getLocation()));
        return weatherInfo;
    }

    protected Location weatherLocationResponseToLocation(WeatherLocationResponse weatherLocationResponse) {

        if (Objects.isNull(weatherLocationResponse)) {
            return null;
        } else {
            Location location = new Location();
            location.setName(weatherLocationResponse.getName());
            location.setRegion(weatherLocationResponse.getRegion());
            location.setCountry(weatherLocationResponse.getCountry());
            location.setLat(weatherLocationResponse.getLat());
            location.setLon(weatherLocationResponse.getLon());
            location.setTimeZoneId(weatherLocationResponse.getTimeZoneId());
            location.setLocaltimeEpoch(weatherLocationResponse.getLocaltimeEpoch());
            log.info(weatherLocationResponse.getLocaltime());
            location.setLocaltimeStr(LocalDateTime.parse(weatherLocationResponse.getLocaltime(), df));
            log.info(weatherLocationResponse.getLocaltime());
            log.info(LocalDateTime.parse(weatherLocationResponse.getLocaltime(), df).toString());
            return location;
        }
    }
}
