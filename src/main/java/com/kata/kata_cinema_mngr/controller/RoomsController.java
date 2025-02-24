package com.kata.kata_cinema_mngr.controller;

import com.kata.kata_cinema_mngr.model.RoomModel;
import com.kata.kata_cinema_mngr.services.rooms.RoomsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomsController {

    private final RoomsService roomsService;

    public RoomsController(RoomsService roomsService) {
        this.roomsService = roomsService;
    }

    @GetMapping("/getRooms")
    public List<RoomModel> getRooms() {
        return roomsService.getRooms();
    }

    @PostMapping("/addRoom")
    public ResponseEntity<Integer> addRoom(@RequestBody RoomModel roomModel) {
        Integer addRoomId = roomsService.addRoom(roomModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(addRoomId);
    }

}
