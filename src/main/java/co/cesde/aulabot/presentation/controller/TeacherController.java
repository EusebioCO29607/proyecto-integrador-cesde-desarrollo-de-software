package co.cesde.aulabot.presentation.controller;

import co.cesde.aulabot.domain.models.Teacher;
import co.cesde.aulabot.infrastructure.persistence.jpa.repository.JpaTeacherRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/teachers")
public class TeacherController {

  private final JpaTeacherRepository repository;
  public TeacherController(JpaTeacherRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public List<Teacher> List() {
    return repository.findAll();
  }

  @PostMapping
  public Teacher Create(@RequestBody Teacher teacher) {
    return repository.save(teacher);
  }
}