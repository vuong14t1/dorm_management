package com.example.dorm_management.services;

import com.example.dorm_management.entities.Area;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AreaService {

    Area findAreaById(Long id);
    List<Area> findAllAreas();

    Area addNewArea(Area area);

}
