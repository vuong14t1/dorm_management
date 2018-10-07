package com.example.dorm_management.services;

import com.example.dorm_management.domain.Area;
import com.example.dorm_management.respositories.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private final AreaRepository areaRepository;

    public AreaServiceImpl(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @Override
    public Area findAreaById(Long id) {
        return areaRepository.findById(id).get();
    }

    @Override
    public List<Area> findAllAreas() {

        return areaRepository.findAll();
    }

    @Override
    public Area addNewArea(Area area) {
        return areaRepository.save(area);
    }
}
