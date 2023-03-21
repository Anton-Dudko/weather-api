package com.example.weatherapi.mapper;

import com.example.weatherapi.model.WeatherInfo;
import com.example.weatherapi.model.dto.WeatherRootResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = LocationMapper.class)
public interface WeatherMapper {
    @Mapping(target = "temperature", source = "current.temperature")
    @Mapping(target = "windSpeed", source = "current.windSpeed")
    @Mapping(target = "pressureMb", source = "current.pressureMb")
    @Mapping(target = "humidity", source = "current.humidity")
    @Mapping(target = "weatherConditions", source = "current.condition.text")
    WeatherInfo convertDtoToEntity(WeatherRootResponse source);

}
