package com.kata.kata_cinema_mngr.services.rooms;

import com.kata.kata_cinema_mngr.dao.RoomsDao;
import com.kata.kata_cinema_mngr.model.MovieModel;
import com.kata.kata_cinema_mngr.model.RoomModel;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RoomsServiceImpl implements RoomsService{

    private Jdbi jdbi;

    public RoomsServiceImpl(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    @Override
    public List<RoomModel> getRooms() {
        try(Handle handle = jdbi.open()) {
            RoomsDao roomsDao = handle.attach(RoomsDao.class);
            return roomsDao.getRooms();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    @Override
    public Integer addRoom(RoomModel roomModel) {
        try(Handle handle = jdbi.open()) {
            RoomsDao roomsDao = handle.attach(RoomsDao.class);
            Integer addRoomId = roomsDao.addRoom(roomModel.getRoom(), roomModel.getCapacity());
            return addRoomId;
        } catch (Exception e) {
            return 0;
        }
    }

}
