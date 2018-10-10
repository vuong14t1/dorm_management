package com.example.dorm_management.services;

import com.example.dorm_management.entities.AreaEntity;
import com.example.dorm_management.respositories.AreaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRespository areaRespository;

    public AreaServiceImpl(AreaRespository areaRespository) {
        this.areaRespository = areaRespository;
    }

    @Override
    public List<AreaEntity> findAllAreas() {
        return areaRespository.findAll();
    }

    @Override
    public AreaEntity findAreaById(Integer id) {
        return areaRespository.findOne(id);
    }
}
