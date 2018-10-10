package com.example.dorm_management.services;

import com.example.dorm_management.entities.AreaEntity;
import com.example.dorm_management.respositories.AreaRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ConstantException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public List<AreaEntity> findAllAreas() {
        return areaRepository.findAll();
    }

    @Override
    public AreaEntity findAreaById(Integer id) {
        return areaRepository.findOne(id);
    }

    @Override
    public AreaEntity addNewArea(AreaEntity areaEntity) {
        try{
            return areaRepository.save(areaEntity);
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }

    }

    @Override
    public boolean editArea(AreaEntity areaEntity, AreaEntity areaEntityEdit) {
        try{

            areaEntityEdit.setName(areaEntity.getName());
            areaEntityEdit.setNumberFloor(areaEntity.getNumberFloor());
            areaEntityEdit.setStatus(areaEntity.getStatus());

            areaRepository.save(areaEntityEdit);
            return  true;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return false;
        }
    }
}
