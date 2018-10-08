package com.example.dorm_management.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AreaController.BASE_URL)
public class AreaController {

    public final static String BASE_URL = "/api/areas";

//    @Autowired
//    private AreaServiceImpl areaService;

//    public AreaController(AreaService areaService) {
//        this.areaService = areaService;
//    }

    @GetMapping
    String getAllAreas(){
        return "sdfgh";
    }

//    @GetMapping("/{id}")
//    AreaEntity getAreaById(@PathVariable Integer id){
//        return areaService.findAreaById(id);
//    }
//
//    @PostMapping("/add")
//    AreaEntity addNewArea(@Valid @RequestBody AreaEntity area) {
//        return areaService.addNewArea(area);
//    }
}
