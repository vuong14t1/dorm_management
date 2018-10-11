package com.example.dorm_management.services;

import com.example.dorm_management.entities.Room;
import com.example.dorm_management.respositories.RoomREpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomREpository roomREpository;

    @Override
    public List<Room> findRoomsByFloorId(Integer floorId) {
        return roomREpository.findRoomsBYFloorId(floorId);
    }
}
