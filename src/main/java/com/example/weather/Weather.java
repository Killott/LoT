package com.example.weather;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
