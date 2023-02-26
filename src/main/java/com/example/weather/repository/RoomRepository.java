package com.example.weather.repository;

import com.example.weather.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository  extends JpaRepository<Room, Long> {

    boolean existsById(Long id);

    List<Room> findAll();
}
