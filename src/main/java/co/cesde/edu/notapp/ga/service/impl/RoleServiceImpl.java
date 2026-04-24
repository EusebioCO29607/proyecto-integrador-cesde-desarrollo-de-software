package co.cesde.edu.notapp.ga.service.impl;

import co.cesde.edu.notapp.ga.models.Role;
import co.cesde.edu.notapp.ga.repository.RoleRepository;
import co.cesde.edu.notapp.ga.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {
  private final RoleRepository roleRepository;

  public RoleServiceImpl(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @Override
  public Role create(Role role) {
    if (role == null || isInvalidRole(role)) {
      return null;
    }
    if (roleRepository.existsByName(role.getName())) {
      return null;
    }
    return roleRepository.create(role);
  }

  @Override
  public boolean update(Role roleUpdate) {
    if (roleUpdate == null || roleUpdate.getRoleId() == null) {
      return false;
    }
    if (isInvalidRole(roleUpdate)) {
      return false;
    }
    Role role = roleRepository.findById(roleUpdate.getRoleId());
    if (role == null) {
      return false;
    }
    if (!role.getName().equalsIgnoreCase(roleUpdate.getName())
        && roleRepository.existsByName(roleUpdate.getName())) {
      return false;
    }
    return roleRepository.update(roleUpdate);
  }

  @Override
  public boolean delete (Long roleId) {
    if (roleId == null) {
      return false;
    }
    Role role = roleRepository.findById(roleId);
    if (role == null) {
      return false;
    }
    return roleRepository.delete(roleId);
  }

  @Override
  public List<Role> findAll() {
    return roleRepository.findAll();
  }

  @Override
  public Role findByName(String name) {
    if (name == null ||  name.isBlank()) {
      return null;
    }
    return roleRepository.findByName(name);
  }


  private boolean isInvalidRole(Role role) {
    return !isNotBlank(role.getName())
        || !isNotBlank(role.getDescription());
  }

  private boolean isNotBlank(String value) {
    return value != null && !value.isBlank();
  }
}
