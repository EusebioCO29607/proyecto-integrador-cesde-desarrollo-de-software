package co.cesde.aulabot.presentation.controller;

import co.cesde.aulabot.domain.models.UserRole;
import co.cesde.aulabot.infrastructure.persistence.jpa.repository.JpaUserRoleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/user-roles")
public class UserRoleController {

  private final JpaUserRoleRepository repository;
  public UserRoleController(JpaUserRoleRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public List<UserRole> List() {
    return repository.findAll();
  }

  @PostMapping
  public UserRole Create(@RequestBody UserRole userRole) {
    return repository.save(userRole);
  }
}