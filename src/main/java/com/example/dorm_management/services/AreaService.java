package com.example.dorm_management.services;

import com.example.dorm_management.entities.AreaEntity;

import java.util.List;

public interface AreaService {

    List<AreaEntity> findAllAreas();

    AreaEntity findAreaById(Integer id);

    AreaEntity addNewArea(AreaEntity areaEntity);

    boolean editArea(AreaEntity areaEntity, AreaEntity areaEntityEdit);
}
