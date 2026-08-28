package co.cesde.aulabot.presentation.controller;

import co.cesde.aulabot.domain.models.Student;
import co.cesde.aulabot.infrastructure.persistence.jpa.repository.JpaStudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/students")
public class StudentController {

  private final JpaStudentRepository repository;
  public StudentController(JpaStudentRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public List<Student> List() {
    return repository.findAll();
  }

  @PostMapping
  public Student Create(@RequestBody Student student) {
    return repository.save(student);
  }
}
