package com.example.dorm_management.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "room", schema = "dorm")
public class RoomEntity {
    private Integer id;
    private String name;
    private Integer areaId;
    private Integer numberBed;
    private Integer gender;
    private Integer status;
    private Integer studentMax;
    private Integer studentPresent;
    private Integer studentRegister;
    private Collection<RegisterRoomEntity> registerRoomsById;
    private Collection<RentEntity> rentsById;
    private Collection<RentRoomEntity> rentRoomsById;
    private AreaEntity areaByAreaId;
    private FloorEntity floorByFloorId;
    private CostEntity costByCostId;
    private RoomFunctionEntity roomFunctionByFunctionId;
    private Collection<SubsistenceFeeEntity> subsistenceFeesById;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "areaId")
    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    @Basic
    @Column(name = "numberBed")
    public Integer getNumberBed() {
        return numberBed;
    }

    public void setNumberBed(Integer numberBed) {
        this.numberBed = numberBed;
    }

    @Basic
    @Column(name = "gender")
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "studentMax")
    public Integer getStudentMax() {
        return studentMax;
    }

    public void setStudentMax(Integer studentMax) {
        this.studentMax = studentMax;
    }

    @Basic
    @Column(name = "studentPresent")
    public Integer getStudentPresent() {
        return studentPresent;
    }

    public void setStudentPresent(Integer studentPresent) {
        this.studentPresent = studentPresent;
    }

    @Basic
    @Column(name = "studentRegister")
    public Integer getStudentRegister() {
        return studentRegister;
    }

    public void setStudentRegister(Integer studentRegister) {
        this.studentRegister = studentRegister;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomEntity that = (RoomEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(areaId, that.areaId) &&
                Objects.equals(numberBed, that.numberBed) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(status, that.status) &&
                Objects.equals(studentMax, that.studentMax) &&
                Objects.equals(studentPresent, that.studentPresent) &&
                Objects.equals(studentRegister, that.studentRegister);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, areaId, numberBed, gender, status, studentMax, studentPresent, studentRegister);
    }

    @OneToMany(mappedBy = "roomByRoomId")
    public Collection<RegisterRoomEntity> getRegisterRoomsById() {
        return registerRoomsById;
    }

    public void setRegisterRoomsById(Collection<RegisterRoomEntity> registerRoomsById) {
        this.registerRoomsById = registerRoomsById;
    }

    @OneToMany(mappedBy = "roomByRoomId")
    public Collection<RentEntity> getRentsById() {
        return rentsById;
    }

    public void setRentsById(Collection<RentEntity> rentsById) {
        this.rentsById = rentsById;
    }

    @OneToMany(mappedBy = "roomByRoomId")
    public Collection<RentRoomEntity> getRentRoomsById() {
        return rentRoomsById;
    }

    public void setRentRoomsById(Collection<RentRoomEntity> rentRoomsById) {
        this.rentRoomsById = rentRoomsById;
    }

    @ManyToOne
    @JoinColumn(name = "areaId", referencedColumnName = "id", nullable = false)
    public AreaEntity getAreaByAreaId() {
        return areaByAreaId;
    }

    public void setAreaByAreaId(AreaEntity areaByAreaId) {
        this.areaByAreaId = areaByAreaId;
    }

    @ManyToOne
    @JoinColumn(name = "floorId", referencedColumnName = "id", nullable = false)
    public FloorEntity getFloorByFloorId() {
        return floorByFloorId;
    }

    public void setFloorByFloorId(FloorEntity floorByFloorId) {
        this.floorByFloorId = floorByFloorId;
    }

    @ManyToOne
    @JoinColumn(name = "costId", referencedColumnName = "id", nullable = false)
    public CostEntity getCostByCostId() {
        return costByCostId;
    }

    public void setCostByCostId(CostEntity costByCostId) {
        this.costByCostId = costByCostId;
    }

    @ManyToOne
    @JoinColumn(name = "functionId", referencedColumnName = "id", nullable = false)
    public RoomFunctionEntity getRoomFunctionByFunctionId() {
        return roomFunctionByFunctionId;
    }

    public void setRoomFunctionByFunctionId(RoomFunctionEntity roomFunctionByFunctionId) {
        this.roomFunctionByFunctionId = roomFunctionByFunctionId;
    }

    @OneToMany(mappedBy = "roomByRoomId")
    public Collection<SubsistenceFeeEntity> getSubsistenceFeesById() {
        return subsistenceFeesById;
    }

    public void setSubsistenceFeesById(Collection<SubsistenceFeeEntity> subsistenceFeesById) {
        this.subsistenceFeesById = subsistenceFeesById;
    }
}
