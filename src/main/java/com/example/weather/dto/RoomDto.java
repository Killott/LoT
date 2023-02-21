package com.example.weather.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class RoomDto {

    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}
