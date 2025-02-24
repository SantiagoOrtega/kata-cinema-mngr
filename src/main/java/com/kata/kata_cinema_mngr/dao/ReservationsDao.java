package com.kata.kata_cinema_mngr.dao;

import com.kata.kata_cinema_mngr.model.ReservationModel;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.sql.SQLException;
import java.util.List;

public interface ReservationsDao {

    @SqlQuery("SELECT * FROM reservations;")
    @RegisterBeanMapper(ReservationModel.class)
    List<ReservationModel> getReservations() throws SQLException;

    @SqlUpdate("INSERT INTO reservations (movie, room, schedule, seats, email) VALUES (:movie, :room, :schedule, :seats, :email);")
    @GetGeneratedKeys
    Integer addReservation(@Bind("movie") String movie, @Bind("room") String room, @Bind("schedule") String schedule,
                           @Bind("seats") String seats, @Bind("email") String email) throws SQLException;

}
