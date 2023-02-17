package com.example.weather;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private final WeatherRepository weatherRepository;

    @GetMapping("/getNow")
    public Weather getNowWeather(@RequestParam Long roomId) {
        return weatherRepository.findTopByIdOOrderByIdDesc(roomId);
    }

    @GetMapping("/getAll")
    public List<Weather> getAllWeather(@RequestParam Long roomId) {
        return weatherRepository.findAllByNodeId(roomId);
    }

    @PostMapping
    public Weather addWeather(@RequestBody CreateWeather weather) {
        Weather saveWeather = new Weather();
        saveWeather.setHumidity(weather.getHumidity());
        saveWeather.setRain(weather.isRain());
        saveWeather.setTemperature(weather.getTemperature());
        saveWeather.setNodeId(weather.getNodeId());
        saveWeather.setPressure(weather.getPressure());
        return weatherRepository.save(saveWeather);
    }

    @PostMapping
    public String addWeatherStr(@RequestBody String weather) {
        return weather;
    }

}
