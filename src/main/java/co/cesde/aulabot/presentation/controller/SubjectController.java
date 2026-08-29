package co.cesde.aulabot.presentation.controller;

import co.cesde.aulabot.domain.models.Subject;
import co.cesde.aulabot.infrastructure.persistence.jpa.repository.JpaSubjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/subjects")
public class SubjectController {

  private final JpaSubjectRepository repository;
  public SubjectController(JpaSubjectRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public List<Subject> List() {
    return repository.findAll();
  }

  @PostMapping
  public Subject Create(@RequestBody Subject subject) {
    return repository.save(subject);
  }
}