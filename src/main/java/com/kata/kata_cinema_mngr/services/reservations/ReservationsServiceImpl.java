package com.kata.kata_cinema_mngr.services.reservations;

import com.kata.kata_cinema_mngr.dao.ReservationsDao;
import com.kata.kata_cinema_mngr.model.ReservationModel;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ReservationsServiceImpl implements ReservationsService {

    private final Jdbi jdbi;

    public ReservationsServiceImpl(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    @Override
    public List<ReservationModel> getReservations() {
        try(Handle handle = jdbi.open()) {
            ReservationsDao reservationsDao = handle.attach(ReservationsDao.class);
            return reservationsDao.getReservations();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    @Override
    public Integer addReservation(ReservationModel reservationModel) {
        try(Handle handle = jdbi.open()) {
            ReservationsDao reservationsDao = handle.attach(ReservationsDao.class);
            Integer addReservationId = reservationsDao.addReservation(reservationModel.getMovie(),
                    reservationModel.getRoom(),
                    reservationModel.getSchedule(),
                    reservationModel.getSeats(),
                    reservationModel.getEmail());
            return addReservationId;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public List<ReservationModel> getReservationsByEmail(String email) {
        try(Handle handle = jdbi.open()) {
            ReservationsDao reservationsDao = handle.attach(ReservationsDao.class);
            return reservationsDao.getReservationsByEmail(email);
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

}
