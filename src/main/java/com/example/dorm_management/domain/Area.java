package com.example.dorm_management.domain;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long area_id;
    private String name;
    private int number_floor;
    private double cost_room;

    public Long getArea_id() {
        return area_id;
    }

    public void setArea_id(Long area_id) {
        this.area_id = area_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber_floor() {
        return number_floor;
    }

    public void setNumber_floor(int number_floor) {
        this.number_floor = number_floor;
    }

    public double getCost_room() {
        return cost_room;
    }

    public void setCost_room(double cost_room) {
        this.cost_room = cost_room;
    }

    public Area(Long area_id, String name, int number_floor, double cost_room) {
        this.area_id = area_id;
        this.name = name;
        this.number_floor = number_floor;
        this.cost_room = cost_room;
    }

    public Area() {
    }
}
