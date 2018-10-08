package com.example.dorm_management.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "dorm")
@Inheritance(strategy=InheritanceType.JOINED)
public class UserEntity {
    private Integer id;
    private String userName;
    private String password;
    private Integer gender;
    private Integer studentCode;
    private Integer roleId;
    private Integer status;
    private Collection<RegisterRoomEntity> registerRoomsById;
    private Collection<RentEntity> rentsById;
    private Collection<RentRoomEntity> rentRoomsById;
    private Collection<RoleUserEntity> roleUsersById;
    private Collection<StudentCodeEntity> studentCodesById;
    private UserDetailEntity userDetailById;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    @Column(name = "studentCode")
    public Integer getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(Integer studentCode) {
        this.studentCode = studentCode;
    }

    @Basic
    @Column(name = "roleId")
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(password, that.password) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(studentCode, that.studentCode) &&
                Objects.equals(roleId, that.roleId) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password, gender, studentCode, roleId, status);
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<RegisterRoomEntity> getRegisterRoomsById() {
        return registerRoomsById;
    }

    public void setRegisterRoomsById(Collection<RegisterRoomEntity> registerRoomsById) {
        this.registerRoomsById = registerRoomsById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<RentEntity> getRentsById() {
        return rentsById;
    }

    public void setRentsById(Collection<RentEntity> rentsById) {
        this.rentsById = rentsById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<RentRoomEntity> getRentRoomsById() {
        return rentRoomsById;
    }

    public void setRentRoomsById(Collection<RentRoomEntity> rentRoomsById) {
        this.rentRoomsById = rentRoomsById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<RoleUserEntity> getRoleUsersById() {
        return roleUsersById;
    }

    public void setRoleUsersById(Collection<RoleUserEntity> roleUsersById) {
        this.roleUsersById = roleUsersById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<StudentCodeEntity> getStudentCodesById() {
        return studentCodesById;
    }

    public void setStudentCodesById(Collection<StudentCodeEntity> studentCodesById) {
        this.studentCodesById = studentCodesById;
    }

    @OneToOne(mappedBy = "userByUserId")
    public UserDetailEntity getUserDetailById() {
        return userDetailById;
    }

    public void setUserDetailById(UserDetailEntity userDetailById) {
        this.userDetailById = userDetailById;
    }
}
