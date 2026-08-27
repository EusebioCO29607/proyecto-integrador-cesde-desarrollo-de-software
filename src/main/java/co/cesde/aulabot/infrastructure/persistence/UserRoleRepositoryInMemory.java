package co.cesde.aulabot.infrastructure.persistence;

import co.cesde.aulabot.domain.models.UserRole;
import co.cesde.aulabot.domain.repository.UserRoleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserRoleRepositoryInMemory implements UserRoleRepository {

    private final List<UserRole> userRoles = new ArrayList<>();

    @Override
    public UserRole create(UserRole userRole) {
        userRoles.add(userRole);
        return userRole;
    }

    @Override
    public boolean delete(Long userId, Long roleId) {
        return userRoles.removeIf(ur -> Objects.equals(ur.getUserId(), userId)
                && Objects.equals(ur.getRoleId(), roleId));
    }

    @Override
    public boolean update(UserRole userRoleUpdate) {
        for (int i = 0; i < userRoles.size(); i++) {
            UserRole current = userRoles.get(i);
            if (Objects.equals(current.getUserId(), userRoleUpdate.getUserId())
                    && Objects.equals(current.getRoleId(), userRoleUpdate.getRoleId())) {
                userRoles.set(i, userRoleUpdate);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<UserRole> findByUserId(Long userId) {
        return userRoles.stream()
                .filter(ur -> Objects.equals(ur.getUserId(), userId))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserRole> findByRoleId(Long roleId) {
        return userRoles.stream()
                .filter(ur -> Objects.equals(ur.getRoleId(), roleId))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserRole> findAll() {
        return new ArrayList<>(userRoles);
    }

    @Override
    public boolean existsByUserIdAndRoleId(Long userId, Long roleId) {
        return userRoles.stream()
                .anyMatch(ur -> Objects.equals(ur.getUserId(), userId)
                        && Objects.equals(ur.getRoleId(), roleId));
    }
}
