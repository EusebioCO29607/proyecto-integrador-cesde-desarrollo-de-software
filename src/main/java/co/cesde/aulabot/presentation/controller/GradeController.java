package co.cesde.aulabot.presentation.controller;

import co.cesde.aulabot.domain.models.Grade;
import co.cesde.aulabot.infrastructure.persistence.jpa.repository.JpaGradeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/grades")
public class GradeController {

  private final JpaGradeRepository repository;
  public GradeController(JpaGradeRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public List<Grade> List() {
    return repository.findAll();
  }

  @PostMapping
  public Grade Create(@RequestBody Grade grade) {
    return repository.save(grade);
  }
}