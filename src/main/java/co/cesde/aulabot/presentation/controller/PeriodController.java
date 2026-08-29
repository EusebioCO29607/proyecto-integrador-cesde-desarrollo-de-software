package co.cesde.aulabot.presentation.controller;

import co.cesde.aulabot.domain.models.Period;
import co.cesde.aulabot.infrastructure.persistence.jpa.repository.JpaPeriodRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/periods")
public class PeriodController {

  private final JpaPeriodRepository repository;
  public PeriodController(JpaPeriodRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public List<Period> List() {
    return repository.findAll();
  }

  @PostMapping
  public Period Create(@RequestBody Period period) {
    return repository.save(period);
  }
}