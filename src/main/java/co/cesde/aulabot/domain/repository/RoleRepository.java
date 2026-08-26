package co.cesde.aulabot.domain.repository;

import co.cesde.aulabot.domain.models.Role;

import java.util.List;

public interface RoleRepository {

  Role create(Role role);

  boolean delete(Long roleId);

  boolean update(Role roleUpdate);

  Role findById(Long roleId);

  Role findByName(String name);

  List<Role> findAll();

  boolean existsByName(String name);

}
