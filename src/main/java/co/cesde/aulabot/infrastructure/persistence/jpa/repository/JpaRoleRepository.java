package co.cesde.aulabot.infrastructure.persistence.jpa.repository;

import co.cesde.aulabot.domain.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaRoleRepository extends JpaRepository<Role, Long> {

  Role save(Role role);

  boolean existsByName(String name);

  List<Role> findAll();

}