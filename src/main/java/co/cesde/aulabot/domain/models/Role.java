package co.cesde.aulabot.domain.models;

import jakarta.persistence.*;

@Entity
@Table (name = "roles")

public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long roleId;
  @Column (
          nullable = false,
          length = 50
  )
  private String name;
  @Column (
          name = "description",
          length = 255
  )
  private String description;

  public Role() {

  }

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Role(Long roleId, String name, String description) {
    this.roleId = roleId;
    this.name = name;
    this.description = description;
  }

  @Override
  public String toString() {
    return "Role{" +
            "roleId= '" + roleId + '\'' +
            ", name= " + name +
            ", description= " + description +
            '}';
  }

}