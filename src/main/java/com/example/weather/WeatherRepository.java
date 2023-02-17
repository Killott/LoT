package com.example.weather;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface WeatherRepository  extends JpaRepository<Weather, Long> {

    Weather findTopByIdOOrderByIdDesc(Long nodeId);

    List<Weather> findAllByNodeId(Long roomId);
}
