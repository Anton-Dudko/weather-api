package com.example.weatherapi.mapper;

import com.example.weatherapi.model.WeatherInfo;
import com.example.weatherapi.model.dto.WeatherRootResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WeatherMapper {
    WeatherInfo convertDtoToEntity(WeatherRootResponse weatherRootResponse);

}
