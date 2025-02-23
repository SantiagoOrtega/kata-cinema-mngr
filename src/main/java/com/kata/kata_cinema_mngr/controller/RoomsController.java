package com.kata.kata_cinema_mngr.controller;

import com.kata.kata_cinema_mngr.model.RoomModel;
import com.kata.kata_cinema_mngr.services.rooms.RoomsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomsController {

    private RoomsService roomsService;

    public RoomsController(RoomsService roomsService) {
        this.roomsService = roomsService;
    }

    @GetMapping("/getRooms")
    public List<RoomModel> getRooms() {
        return roomsService.getRooms();
    }

}
