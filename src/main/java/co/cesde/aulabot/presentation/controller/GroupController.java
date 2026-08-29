package co.cesde.aulabot.presentation.controller;

import co.cesde.aulabot.domain.models.Group;
import co.cesde.aulabot.infrastructure.persistence.jpa.repository.JpaGroupRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/groups")
public class GroupController {

  private final JpaGroupRepository repository;
  public GroupController(JpaGroupRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public List<Group> List() {
    return repository.findAll();
  }

  @PostMapping
  public Group Create(@RequestBody Group group) {
    return repository.save(group);
  }
}