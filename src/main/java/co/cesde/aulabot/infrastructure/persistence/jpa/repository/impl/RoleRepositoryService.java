package co.cesde.aulabot.infrastructure.persistence.jpa.repository.impl;

import co.cesde.aulabot.domain.models.Role;
import co.cesde.aulabot.domain.repository.RoleRepository;
import co.cesde.aulabot.infrastructure.persistence.jpa.repository.JpaRoleRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public abstract class RoleRepositoryService implements RoleRepository {

  private final JpaRoleRepository jpaRoleRepository;

  public RoleRepositoryService(JpaRoleRepository jpaRoleRepository) {
    this.jpaRoleRepository = jpaRoleRepository;
  }

  @Override
  public Role create(Role role) {
    if (role == null) {
      throw new IllegalArgumentException("Role cannot be null");
    }
    if (existsByName(role.getName())) {
      throw new IllegalArgumentException("Role with name " + role.getName() + " already exists");
    }
    return jpaRoleRepository.save(role);
  }

  @Override
  public boolean delete(Long roleId) {
    if (roleId == null || jpaRoleRepository.findById(roleId).isEmpty()) {
      return false;
    }
    jpaRoleRepository.deleteById(roleId);
    return true;
  }

  @Override
  public boolean update(Role roleUpdate) {
    if (roleUpdate == null || roleUpdate.getRoleId() == null) {
      return false;
    }
    if (jpaRoleRepository.findById(roleUpdate.getRoleId()).isEmpty()) {
      return false;
    }
    jpaRoleRepository.save(roleUpdate);
    return true;
  }

  @Override
  public Role findById(Long roleId) {
    return jpaRoleRepository.findById(roleId).orElse(null);
  }

  @Override
  public List<Role> findAll() {
    return jpaRoleRepository.findAll();
  }

  @Override
  public boolean existsByName(String name) {
    return jpaRoleRepository.existsByName(name);
  }
}