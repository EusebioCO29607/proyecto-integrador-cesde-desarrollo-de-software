package co.cesde.aulabot.presentation.controller;

import co.cesde.aulabot.domain.models.User;
import co.cesde.aulabot.infrastructure.persistence.jpa.repository.JpaUserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/users")
public class UserController {

  private final JpaUserRepository repository;
  public UserController(JpaUserRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public List<User> List() {
    return repository.findAll();
  }

  @PostMapping
  public User Create(@RequestBody User user) {
    return repository.save(user);
  }
}