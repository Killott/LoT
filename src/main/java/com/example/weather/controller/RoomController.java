package com.example.weather.controller;

import com.example.weather.dto.RoomDto;
import com.example.weather.entity.Room;
import com.example.weather.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {

    @Autowired
    private final RoomRepository roomRepository;

    @GetMapping("/get")
    public Room getRoomById(@RequestParam Long id) {
        return roomRepository.getReferenceById(id);
    }

    @GetMapping("/getAll")
    public List<Room> getRoomAll() {
        return roomRepository.getAll();
    }

    @PutMapping("/rename")
    public Room updateRoom(@RequestBody RoomDto roomDto) {
        Room entity = roomRepository.getReferenceById(roomDto.getId());
        entity.setName(roomDto.getName());
        return roomRepository.save(entity);
    }
}
