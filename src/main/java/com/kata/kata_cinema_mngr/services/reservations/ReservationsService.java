package com.kata.kata_cinema_mngr.services.reservations;

import com.kata.kata_cinema_mngr.model.ReservationModel;

import java.util.List;

public interface ReservationsService {

    List<ReservationModel> getReservations();

    Integer addReservation(ReservationModel reservationModel);

    List<ReservationModel> getReservationsByEmail(String email);

}
