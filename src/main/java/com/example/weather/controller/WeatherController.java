package com.example.weather.controller;

import com.example.weather.entity.Room;
import com.example.weather.repository.RoomRepository;
import com.example.weather.repository.WeatherRepository;
import com.example.weather.dto.CreateWeatherDto;
import com.example.weather.entity.Weather;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private final WeatherRepository weatherRepository;

    @Autowired
    private final RoomRepository roomRepository;

    @GetMapping("/getNow")
    public Weather getNowWeather(@RequestParam Long roomId) {
        return weatherRepository.findTopByNodeIdOrderByIdDesc(roomId);
    }

    @GetMapping("/getAll")
    public List<Weather> getAllWeather(@RequestParam Long roomId) {
        return weatherRepository.findAllByNodeId(roomId);
    }

    @PostMapping
    public Weather addWeather(@RequestBody CreateWeatherDto weather) {
        Weather saveWeather = new Weather();
        saveWeather.setHumidity(weather.getHumidity());
        saveWeather.setRain(weather.isRain());
        saveWeather.setTemperature(weather.getTemperature());
        saveWeather.setNodeId(weather.getNodeId());
        saveWeather.setPressure(weather.getPressure());

        if (!roomRepository.existsById(weather.getNodeId())) {
            Room entity = new Room(weather.getNodeId());
            roomRepository.save(entity);
        }

        return weatherRepository.save(saveWeather);
    }

}
