package com.example.weatherapi.repository;

import com.example.weatherapi.model.WeatherInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface WeatherRepository extends CrudRepository<WeatherInfo, Long> {

    WeatherInfo findFirstByOrderByLocation_LocaltimeStrDesc();
    WeatherInfo findByLocation_LocaltimeStr(LocalDateTime localDateTime);

    @Query(value = "select avg(temperature) " +
            "from weather_info w left join location l ON l.id = w.location_id " +
            "where (l.localtime_str between :from and :to )", nativeQuery = true)
    double averageTemperature(LocalDate from, LocalDate to);

}