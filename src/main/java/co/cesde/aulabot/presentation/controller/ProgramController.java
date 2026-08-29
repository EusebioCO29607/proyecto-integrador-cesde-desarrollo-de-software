package co.cesde.aulabot.presentation.controller;

import co.cesde.aulabot.domain.models.Program;
import co.cesde.aulabot.infrastructure.persistence.jpa.repository.JpaProgramRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/programs")
public class ProgramController {

  private final JpaProgramRepository repository;
  public ProgramController(JpaProgramRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public List<Program> List() {
    return repository.findAll();
  }

  @PostMapping
  public Program Create(@RequestBody Program program) {
    return repository.save(program);
  }
}