package com.example.weatherapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    @NotNull
    private double lat;
    @NotNull
    private double lon;

    private String timeZoneId;

    private Long localtimeEpoch;
    private LocalDateTime localtimeStr;

    @OneToOne(mappedBy = "location")
    @JsonIgnore
    private WeatherInfo weatherInfo;

}
