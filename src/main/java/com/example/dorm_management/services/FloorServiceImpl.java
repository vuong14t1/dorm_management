package com.example.dorm_management.services;

import com.example.dorm_management.entities.Floor;
import com.example.dorm_management.respositories.FloorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FloorServiceImpl implements FloorService {
    @Autowired
    private FloorRepository floorRepository;

    @Override
    public List<Floor> findFloorsByAreaId(Integer areaId) {
        return null;
    }
}
