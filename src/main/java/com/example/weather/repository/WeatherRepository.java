package com.example.weather.repository;

import com.example.weather.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository  extends JpaRepository<Weather, Long> {

    Weather findTopByIdOrderByIdDesc(Long nodeId);

    List<Weather> findAllByNodeId(Long roomId);
}
