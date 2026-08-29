package co.cesde.aulabot.infrastructure.persistence.jpa.repository.impl;

import co.cesde.aulabot.domain.models.User;
import co.cesde.aulabot.domain.repository.UserRepository;
import co.cesde.aulabot.infrastructure.persistence.jpa.repository.JpaUserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public abstract class UserRepositoryService implements UserRepository {

  private final JpaUserRepository jpaUserRepository;

  public UserRepositoryService(JpaUserRepository jpaUserRepository) {
    this.jpaUserRepository = jpaUserRepository;
  }

  @Override
  public User create(User user) {
    if (user == null) {
      throw new IllegalArgumentException("User cannot be null");
    }
    if (existsByUsername(user.getUsername())) {
      throw new IllegalArgumentException("User with username " + user.getUsername() + " already exists");
    }
    if (existsByEmail(user.getEmail())) {
      throw new IllegalArgumentException("User with email " + user.getEmail() + " already exists");
    }
    return jpaUserRepository.save(user);
  }

  @Override
  public boolean delete(Long userId) {
    if (userId == null || jpaUserRepository.findById(userId).isEmpty()) {
      return false;
    }
    jpaUserRepository.deleteById(userId);
    return true;
  }

  @Override
  public boolean update(User userUpdate) {
    if (userUpdate == null || userUpdate.getUserId() == null) {
      return false;
    }
    if (jpaUserRepository.findById(userUpdate.getUserId()).isEmpty()) {
      return false;
    }
    jpaUserRepository.save(userUpdate);
    return true;
  }

  @Override
  public User findById(Long userId) {
    return jpaUserRepository.findById(userId).orElse(null);
  }

  @Override
  public User findByUsername(String username) {
    return jpaUserRepository.findByUsername(username).orElse(null);
  }

  @Override
  public List<User> findAll() {
    return jpaUserRepository.findAll();
  }

  @Override
  public boolean existsByUsername(String username) {
    return jpaUserRepository.existsByUsername(username);
  }

  @Override
  public boolean existsByEmail(String email) {
    return jpaUserRepository.existsByEmail(email);
  }
}