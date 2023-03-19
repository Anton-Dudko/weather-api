package com.example.weatherapi.repository;

import com.example.weatherapi.model.WeatherInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends CrudRepository<WeatherInfo, Long> {

    WeatherInfo findFirstByOrderByLocation_Id();

}
