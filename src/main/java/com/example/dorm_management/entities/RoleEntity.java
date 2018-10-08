package com.example.dorm_management.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "role", schema = "dorm")
public class RoleEntity {
    private Integer id;
    private Integer groupId;
    private Integer actionId;
    private GroupsEntity groupsByGroupId;
    private ActionEntity actionByActionId;
    private Collection<RoleUserEntity> roleUsersById;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "groupId")
    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "actionId")
    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(groupId, that.groupId) &&
                Objects.equals(actionId, that.actionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupId, actionId);
    }

    @ManyToOne
    @JoinColumn(name = "groupId", referencedColumnName = "id", nullable = false)
    public GroupsEntity getGroupsByGroupId() {
        return groupsByGroupId;
    }

    public void setGroupsByGroupId(GroupsEntity groupsByGroupId) {
        this.groupsByGroupId = groupsByGroupId;
    }

    @ManyToOne
    @JoinColumn(name = "actionId", referencedColumnName = "id", nullable = false)
    public ActionEntity getActionByActionId() {
        return actionByActionId;
    }

    public void setActionByActionId(ActionEntity actionByActionId) {
        this.actionByActionId = actionByActionId;
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<RoleUserEntity> getRoleUsersById() {
        return roleUsersById;
    }

    public void setRoleUsersById(Collection<RoleUserEntity> roleUsersById) {
        this.roleUsersById = roleUsersById;
    }
}
