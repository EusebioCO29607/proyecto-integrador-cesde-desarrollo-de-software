package co.cesde.edu.notapp.ga.repository.impl;

import co.cesde.edu.notapp.ga.models.Role;
import co.cesde.edu.notapp.ga.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;

public class RoleRepositoryInMemory implements RoleRepository {

  private List<Role> roles;
  private Long nextRoleId;

  public RoleRepositoryInMemory() {
    this.roles = new ArrayList<>();
    this.nextRoleId = 1L;
  }

  @Override
  public Role create(Role role) {
    if (role == null) {
      return null;
    }
    role.setRoleId(nextRoleId++);
    roles.add(role);
    return  role;
  }

  @Override
  public boolean delete(Long roleId) {
    if (roleId == null) {
      return false;
    }
    Role role = findById(roleId);
    if (role == null) {
      return false;
    }
    return roles.remove(role);
  }

  @Override
  public boolean update(Role roleUpdate) {
    if (roleUpdate == null || roleUpdate.getRoleId() == null) {
      return false;
    }
    for (int i = 0; i < roles.size(); i++) {
      if (roles.get(i).getRoleId().equals(roleUpdate.getRoleId())) {
        roles.set(i, roleUpdate);
        return true;
      }
    }
    return false;
  }

  @Override
  public Role findById(Long roleId) {
    if (roleId == null || roleId < 0L) {
      return null;
    }
    for (Role role : roles) {
      if (role.getRoleId().equals(roleId)) {
        return role;
      }
    }
    return null;
  }

  @Override
  public Role findByName(String name) {
    if (name == null || name.isBlank()) {
      return null;
    }
    for (Role role : roles) {
      if (role.getName().equalsIgnoreCase(name)) { // equalsIgnoreCase en lugar de equals, ya que los nombres de roles como "ADMIN", "Admin" o "admin" deben tratarse como el mismo rol para evitar duplicados por diferencia de mayúsculas.
        return role;
      }
    }
    return null;
  }
  @Override
  public List<Role> findAll() {
    return List.of(roles.toArray(new Role[0]));
  }

  @Override
  public boolean existsByName(String name) {
    return findByName(name) != null;
  }

}
