package com.example.weather.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "room")
@RequiredArgsConstructor
public class Room {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    public Room(Long id) {
        this.id = id;
    }
}
