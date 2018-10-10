package com.example.dorm_management.services;

import com.example.dorm_management.entities.AreaEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AreaService {

    List<AreaEntity> findAllAreas();

    AreaEntity findAreaById(Integer id);
}
