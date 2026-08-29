package co.cesde.aulabot.presentation.controller;

import co.cesde.aulabot.domain.models.Role;
import co.cesde.aulabot.infrastructure.persistence.jpa.repository.JpaRoleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/roles")
public class RoleController {

  private final JpaRoleRepository repository;
  public RoleController(JpaRoleRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public List<Role> List() {
    return repository.findAll();
  }

  @PostMapping
  public Role Create(@RequestBody Role role) {
    return repository.save(role);
  }
}