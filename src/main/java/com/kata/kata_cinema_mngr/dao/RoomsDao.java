package com.kata.kata_cinema_mngr.dao;

import com.kata.kata_cinema_mngr.model.RoomModel;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.sql.SQLException;
import java.util.List;

public interface RoomsDao {

    @SqlQuery("SELECT * FROM rooms;")
    @RegisterBeanMapper(RoomModel.class)
    List<RoomModel> getRooms() throws SQLException;

}
