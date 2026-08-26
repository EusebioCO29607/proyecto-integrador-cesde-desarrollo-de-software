package co.cesde.aulabot.application.service;

import co.cesde.aulabot.domain.models.Role;

import java.util.List;

public interface RoleService {

  Role create(Role role);

  boolean update(Role roleUpdate);

  boolean delete(Long roleId);

  Role findByName(String name);

  List<Role> findAll();

}
