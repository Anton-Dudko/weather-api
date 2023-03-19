package com.example.weatherapi.mapper;

import com.example.weatherapi.model.Location;
import com.example.weatherapi.model.WeatherInfo;
import com.example.weatherapi.model.dto.WeatherLocationResponse;
import com.example.weatherapi.model.dto.WeatherRootResponse;
import org.springframework.stereotype.Component;

@Component
public class WeatherMapperImple implements WeatherMapper {

    @Override
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
        if (weatherLocationResponse == null) {
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
            location.setLocaltimeStr(weatherLocationResponse.getLocaltime());
            return location;
        }
    }
}
