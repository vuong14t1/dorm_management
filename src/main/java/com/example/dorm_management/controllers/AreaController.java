package com.example.dorm_management.controllers;

import com.example.dorm_management.entities.AreaEntity;
import com.example.dorm_management.services.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(AreaController.BASE_URL)
public class AreaController {

    public final static String BASE_URL = "/api/areas";

    @Autowired
    private AreaService areaService;

//
//    public AreaController(AreaService areaService) {
//        this.areaService = areaService;
//    }

    /*get all area in system*/
    @GetMapping
    public List<AreaEntity> getAllAreas(){
        return areaService.findAllAreas();
    }

    /*get one area by id area*/
    @GetMapping(value = "/{id}")
    public ResponseEntity<AreaEntity> getAreaById(@PathVariable Integer id){
        AreaEntity areaEntity = areaService.findAreaById(id);
        if ( areaEntity == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(areaEntity);
//            return new  ResponseEntity<>(areaEntity, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<AreaEntity> updateArea(@PathVariable(value = "id") Integer id, @Valid @RequestBody AreaEntity areaEntity, Error error){
     public ResponseEntity<AreaEntity> updateArea(@PathVariable(value = "id") Integer id, @Valid @RequestBody AreaEntity areaEntity){
//         if(error.hashCode()) {
//            return ResponseEntity.badRequest().body(ValidationErrorBuilder.fromBindingErrors(errors));
//
//        }

        AreaEntity areaEntityEdit = areaService.findAreaById(id);

        if (areaEntityEdit == null) {
            return ResponseEntity.notFound().build();
//            ResponseEntity.badRequest().body("Year of birth cannot /**/be in the future");
        }

        if ( areaService.editArea(areaEntity, areaEntityEdit) == true) {
            return ResponseEntity.ok().body(areaEntityEdit);
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AreaEntity> addNewArea(@Valid @RequestBody AreaEntity areaEntity) {
        if (areaService.addNewArea(areaEntity) == null) {
            return ResponseEntity.ok().body(areaEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
