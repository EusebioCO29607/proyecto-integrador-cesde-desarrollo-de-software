package co.cesde.edu.notapp.ga.models;

public class Roles {

  private long roleId;
  private String name;
  private String description;

  public Roles() {

  }

  public long getRoleId() {
    return roleId;
  }

  public void setRoleId(long roleId) {
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

  public Roles(long roleId, String name, String description) {
    this.roleId = roleId;
    this.name = name;
    this.description = description;
  }

  @Override
  public String toString() {
    return "Roles{" +
        "roleId= '" + roleId + '\'' +
        ", name= " + name +
        ", description= " + description +
        '}';
  }

}
