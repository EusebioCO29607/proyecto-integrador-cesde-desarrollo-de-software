package co.cesde.aulabot.domain.models;

import jakarta.persistence.*;

@Entity
@Table (name = "user_roles")

public class UserRole {
    @Id
    @Column (
            name = "user_id"
    )
    private Long userId;
    @Id
    @Column (
            name = "role_id"
    )
    private Long roleId;

    public UserRole() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public UserRole(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userId= '" + userId + '\'' +
                ", roleId= " + roleId +
                '}';
    }

}