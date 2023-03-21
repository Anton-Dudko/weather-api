package com.example.weatherapi.repository;

import com.example.weatherapi.model.WeatherInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface WeatherRepository extends CrudRepository<WeatherInfo, Long> {

    WeatherInfo findFirstByOrderByLocation_LocaltimeStrDesc();

    @Query(value = "select avg(temperature) " +
            "from WeatherInfo w left join Location l ON l.id = w.location_id " +
            "where (l.localtime_str between :from and :to )", nativeQuery = true)
    Double averageTemperature(@Param("from") LocalDateTime from, @Param("to") LocalDateTime to);

}