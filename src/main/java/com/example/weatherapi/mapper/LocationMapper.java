package com.example.weatherapi.mapper;

import com.example.weatherapi.model.Location;
import com.example.weatherapi.model.dto.WeatherLocationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    @Mapping(target = "localtimeStr", source = "weatherLocationResponse.localtime",
            dateFormat = "yyyy-MM-dd H:mm")
    Location convertDtoToEntity(WeatherLocationResponse weatherLocationResponse);

    WeatherLocationResponse convertEntityToDto(Location location);
}
