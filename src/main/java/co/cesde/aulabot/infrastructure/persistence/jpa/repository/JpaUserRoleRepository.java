package co.cesde.aulabot.infrastructure.persistence.jpa.repository;

import co.cesde.aulabot.domain.models.UserRole;
import co.cesde.aulabot.domain.models.UserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaUserRoleRepository extends JpaRepository<UserRole, UserRoleId> {

  UserRole save(UserRole userRole);

  List<UserRole> findByUserId(Long userId);

  List<UserRole> findByRoleId(Long roleId);

  boolean existsByUserIdAndRoleId(Long userId, Long roleId);

  List<UserRole> findAll();

}