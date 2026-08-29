package co.cesde.aulabot.presentation.controller;

import co.cesde.aulabot.domain.models.Enrollment;
import co.cesde.aulabot.infrastructure.persistence.jpa.repository.JpaEnrollmentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/enrollments")
public class EnrollmentController {

  private final JpaEnrollmentRepository repository;
  public EnrollmentController(JpaEnrollmentRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public List<Enrollment> List() {
    return repository.findAll();
  }

  @PostMapping
  public Enrollment Create(@RequestBody Enrollment enrollment) {
    return repository.save(enrollment);
  }
}