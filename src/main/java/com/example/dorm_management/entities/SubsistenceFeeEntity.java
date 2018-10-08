package com.example.dorm_management.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subsistence_fee", schema = "dorm")
public class SubsistenceFeeEntity {
    private Integer id;
    private Integer month;
    private Integer year;
    private Integer oldNumber;
    private Integer newNumber;
    private Double total;
    private Integer type;
    private Integer roomId;
    private Integer costId;
    private Integer level;
    private Integer status;
    private RoomEntity roomByRoomId;
    private CostEntity costByCostId;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "month")
    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    @Basic
    @Column(name = "year")
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Basic
    @Column(name = "oldNumber")
    public Integer getOldNumber() {
        return oldNumber;
    }

    public void setOldNumber(Integer oldNumber) {
        this.oldNumber = oldNumber;
    }

    @Basic
    @Column(name = "newNumber")
    public Integer getNewNumber() {
        return newNumber;
    }

    public void setNewNumber(Integer newNumber) {
        this.newNumber = newNumber;
    }

    @Basic
    @Column(name = "total")
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "roomId")
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "costId")
    public Integer getCostId() {
        return costId;
    }

    public void setCostId(Integer costId) {
        this.costId = costId;
    }

    @Basic
    @Column(name = "level")
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubsistenceFeeEntity that = (SubsistenceFeeEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(month, that.month) &&
                Objects.equals(year, that.year) &&
                Objects.equals(oldNumber, that.oldNumber) &&
                Objects.equals(newNumber, that.newNumber) &&
                Objects.equals(total, that.total) &&
                Objects.equals(type, that.type) &&
                Objects.equals(roomId, that.roomId) &&
                Objects.equals(costId, that.costId) &&
                Objects.equals(level, that.level) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, month, year, oldNumber, newNumber, total, type, roomId, costId, level, status);
    }

    @ManyToOne
    @JoinColumn(name = "roomId", referencedColumnName = "id", nullable = false)
    public RoomEntity getRoomByRoomId() {
        return roomByRoomId;
    }

    public void setRoomByRoomId(RoomEntity roomByRoomId) {
        this.roomByRoomId = roomByRoomId;
    }

    @ManyToOne
    @JoinColumn(name = "costId", referencedColumnName = "id", nullable = false)
    public CostEntity getCostByCostId() {
        return costByCostId;
    }

    public void setCostByCostId(CostEntity costByCostId) {
        this.costByCostId = costByCostId;
    }
}
