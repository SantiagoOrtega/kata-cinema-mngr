package com.kata.kata_cinema_mngr.controller;


import com.kata.kata_cinema_mngr.model.ReservationModel;
import com.kata.kata_cinema_mngr.services.reservations.ReservationsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationsController {

    private final ReservationsService reservationsService;

    public ReservationsController(ReservationsService reservationsService) {
        this.reservationsService = reservationsService;
    }

    @GetMapping("/getReservations")
    public List<ReservationModel> getReservations() {
        return reservationsService.getReservations();
    }

    @PostMapping("/addReservation")
    public ResponseEntity<Integer> addReservation(@RequestBody ReservationModel reservationModel) {
        Integer addReservationId = reservationsService.addReservation(reservationModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(addReservationId);
    }

    @GetMapping("/getReservationsByEmail")
    public ResponseEntity<List<ReservationModel>> getReservationByEmail(@RequestParam String email) {
        List<ReservationModel> reservationModels = reservationsService.getReservationsByEmail(email);
        return reservationModels != null ? ResponseEntity.ok(reservationModels) : ResponseEntity.notFound().build();
    }

}
