package com.example.dorm_management.controllerss;

import com.example.dorm_management.domain.Area;
import com.example.dorm_management.services.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(AreaController.BASE_URL)
public class AreaController {

    public final static String BASE_URL = "/api/areas";

    @Autowired
    private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping
    List<Area> getAllAreas(){
        return areaService.findAllAreas();
    }

    @GetMapping("/{id}")
    Area getAreaById(@PathVariable Long id){
        return areaService.findAreaById(id);
    }

    @PostMapping("/add")
    Area addNewArea(@Valid @RequestBody Area area) {
        return areaService.addNewArea(area);
    }
}
