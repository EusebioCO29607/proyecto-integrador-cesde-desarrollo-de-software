package co.cesde.aulabot.infrastructure.persistence.jpa.repository.impl;

import co.cesde.aulabot.domain.models.UserRole;
import co.cesde.aulabot.domain.models.UserRoleId;
import co.cesde.aulabot.domain.repository.UserRoleRepository;
import co.cesde.aulabot.infrastructure.persistence.jpa.repository.JpaUserRoleRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public abstract class UserRoleRepositoryService implements UserRoleRepository {

  private final JpaUserRoleRepository jpaUserRoleRepository;

  public UserRoleRepositoryService(JpaUserRoleRepository jpaUserRoleRepository) {
    this.jpaUserRoleRepository = jpaUserRoleRepository;
  }

  @Override
  public UserRole create(UserRole userRole) {
    if (userRole == null || userRole.getUserId() == null || userRole.getRoleId() == null) {
      throw new IllegalArgumentException("UserRole must have userId and roleId");
    }
    if (exists(userRole.getUserId(), userRole.getRoleId())) {
      throw new IllegalArgumentException("UserRole already exists for userId " + userRole.getUserId() + " and roleId " + userRole.getRoleId());
    }
    return jpaUserRoleRepository.save(userRole);
  }

  @Override
  public boolean delete(Long userId, Long roleId) {
    if (userId == null || roleId == null) {
      return false;
    }
    UserRoleId id = new UserRoleId(userId, roleId);
    if (jpaUserRoleRepository.findById(id).isEmpty()) {
      return false;
    }
    jpaUserRoleRepository.deleteById(id);
    return true;
  }

  @Override
  public UserRole findById(Long userId, Long roleId) {
    if (userId == null || roleId == null) {
      return null;
    }
    return jpaUserRoleRepository.findById(new UserRoleId(userId, roleId)).orElse(null);
  }

  @Override
  public List<UserRole> findByUserId(Long userId) {
    return jpaUserRoleRepository.findByUserId(userId);
  }

  @Override
  public List<UserRole> findByRoleId(Long roleId) {
    return jpaUserRoleRepository.findByRoleId(roleId);
  }

  @Override
  public List<UserRole> findAll() {
    return jpaUserRoleRepository.findAll();
  }

  @Override
  public boolean exists(Long userId, Long roleId) {
    return jpaUserRoleRepository.existsByUserIdAndRoleId(userId, roleId);
  }
}