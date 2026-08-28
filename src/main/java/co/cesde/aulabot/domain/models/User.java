package co.cesde.aulabot.domain.models;

import jakarta.persistence.*;

@Entity
@Table (name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column (
            nullable = false,
            length = 50
    )
    private String username;
    @Column (
            nullable = false,
            length = 50
    )
    private String email;
    @Column (
            nullable = false,
            name = "password_hash",
            length = 255
    )
    private String passwordHash;
    @Column (
            name = "status",
            length = 20
    )
    private String status;
    @Column (
            name = "created_at"
    )
    private String createdAt;

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public User(Long userId, String username, String email, String passwordHash, String status, String createdAt) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.status = status;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId= '" + userId + '\'' +
                ", username= " + username +
                ", email= " + email +
                ", passwordHash= " + passwordHash +
                ", status= " + status +
                ", createdAt= " + createdAt +
                '}';
    }

}