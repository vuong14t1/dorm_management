package com.example.dorm_management.controllers;

import com.example.dorm_management.entities.AreaEntity;
import com.example.dorm_management.services.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AreaController.BASE_URL)
public class AreaController {

    public final static String BASE_URL = "/api/areas";

    @Autowired
    private AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping
    List<AreaEntity> getAllAreas(){
        return areaService.findAllAreas();
    }

    @GetMapping(value = "/{id}")
    AreaEntity getAreaById(@PathVariable Integer id){
        return areaService.findAreaById(id);
    }

}
