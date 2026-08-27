package co.cesde.aulabot.infrastructure.persistence;

import co.cesde.aulabot.domain.models.User;
import co.cesde.aulabot.domain.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserRepositoryInMemory implements UserRepository {

    private final List<User> users = new ArrayList<>();

    @Override
    public User create(User user) {
        users.add(user);
        return user;
    }

    @Override
    public boolean delete(Long userId) {
        return users.removeIf(u -> Objects.equals(u.getUserId(), userId));
    }

    @Override
    public boolean update(User userUpdate) {
        for (int i = 0; i < users.size(); i++) {
            if (Objects.equals(users.get(i).getUserId(), userUpdate.getUserId())) {
                users.set(i, userUpdate);
                return true;
            }
        }
        return false;
    }

    @Override
    public User findById(Long userId) {
        return users.stream()
                .filter(u -> Objects.equals(u.getUserId(), userId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> findByStatus(String status) {
        return users.stream()
                .filter(u -> Objects.equals(u.getStatus(), status))
                .collect(Collectors.toList());
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public boolean existsByUsername(String username) {
        return users.stream()
                .anyMatch(u -> Objects.equals(u.getUsername(), username));
    }

    @Override
    public boolean existsByEmail(String email) {
        return users.stream()
                .anyMatch(u -> Objects.equals(u.getEmail(), email));
    }

    @Override
    public User findByUsername(String username) {
        return users.stream()
                .filter(u -> Objects.equals(u.getUsername(), username))
                .findFirst()
                .orElse(null);
    }
}
