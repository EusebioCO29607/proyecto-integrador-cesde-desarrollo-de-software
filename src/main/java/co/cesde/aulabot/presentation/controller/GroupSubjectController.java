package co.cesde.aulabot.presentation.controller;

import co.cesde.aulabot.domain.models.GroupSubject;
import co.cesde.aulabot.infrastructure.persistence.jpa.repository.JpaGroupSubjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/group-subjects")
public class GroupSubjectController {

  private final JpaGroupSubjectRepository repository;
  public GroupSubjectController(JpaGroupSubjectRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public List<GroupSubject> List() {
    return repository.findAll();
  }

  @PostMapping
  public GroupSubject Create(@RequestBody GroupSubject groupSubject) {
    return repository.save(groupSubject);
  }
}