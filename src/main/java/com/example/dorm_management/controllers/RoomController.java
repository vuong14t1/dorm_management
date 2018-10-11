package com.example.dorm_management.controllers;

import com.example.dorm_management.entities.Area;
import com.example.dorm_management.entities.Floor;
import com.example.dorm_management.entities.Room;
import com.example.dorm_management.json.API;
import com.example.dorm_management.json.JsonResponse;
import com.example.dorm_management.services.FloorService;
import com.example.dorm_management.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(RoomController.BASE_URL)
public class RoomController {

    public final static String BASE_URL               = "/api/room";

    @Autowired
    private RoomService roomService;

    @Autowired
    private FloorService floorService;

    private JsonResponse jsonResponse;

    @GetMapping("/floor/{id}")
    public JsonResponse findRoomsByFloorId(@PathVariable(value = "id") Integer id) {
        Floor floor = floorService.findById(id);
        if (floor == null) {
            jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_NOTFOUND,
                    "Không có tầng nào có id = " + id);

            return jsonResponse;
        } else {
            List<Room> rooms = roomService.findRoomsByFloorId(id);
            if (rooms.size() > 0) {
                jsonResponse = return_List_Object_JsonPresonse(API.CODE_API_YES, "", rooms);

                return jsonResponse;
            } else {
                jsonResponse = return_No_Object_JsonPresonse(API.CODE_API_NOTFOUND, "Không có phòng nào!");

                return jsonResponse;
            }
        }
    }


    public JsonResponse return_No_Object_JsonPresonse(Integer code, String message){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(null);

        return jsonResponse;
    }

    public JsonResponse return_One_Object_JsonPresonse(Integer code, String message, Room room){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.singletonList(room));

        return jsonResponse;
    }

    public JsonResponse return_List_Object_JsonPresonse(Integer code, String message, List<Room> rooms){
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        jsonResponse.setData(Collections.unmodifiableCollection(rooms));

        return jsonResponse;
    }
}
