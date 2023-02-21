package com.example.weather.dto;

import lombok.Data;

import javax.persistence.*;

@Data
public class CreateWeatherDto {

    @Column(name = "temperature")
    private Double temperature;

    @Column(name = "pressure")
    private Double pressure;

    @Column(name = "humidity")
    private Double humidity;

    @Column(name = "rain")
    private boolean rain;

    @Column(name = "node")
    private Long nodeId;
}
