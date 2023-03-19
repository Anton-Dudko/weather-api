package com.example.weatherapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String region;

    private String country;

    private double lat;

    private double lon;

    private String timeZoneId;

    private Long localtimeEpoch;

    private String localtimeStr;

    @OneToOne(mappedBy = "location")
    @JsonIgnore
    private WeatherInfo weatherInfo;

}
