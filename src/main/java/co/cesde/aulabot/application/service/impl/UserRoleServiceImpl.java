package co.cesde.aulabot.application.service.impl;


import co.cesde.aulabot.domain.models.UserRole;
import co.cesde.aulabot.domain.repository.UserRoleRepository;
import co.cesde.aulabot.application.service.UserRoleService;

import java.util.List;

public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRole create(UserRole userRole) {
        if (userRole == null || isInvalidUserRole(userRole)) {
            return null;
        }

        if (userRoleRepository.existsByUserIdAndRoleId(
                userRole.getUserId(), userRole.getRoleId())) {
            return null;
        }
        return userRoleRepository.create(userRole);
    }

    @Override
    public boolean update(UserRole userRoleUpdate) {
        if (userRoleUpdate == null || isInvalidUserRole(userRoleUpdate)) {
            return false;
        }

        if (!userRoleRepository.existsByUserIdAndRoleId(
                userRoleUpdate.getUserId(), userRoleUpdate.getRoleId())) {
            return false;
        }
        return userRoleRepository.update(userRoleUpdate);
    }

    @Override
    public boolean delete(Long userId, Long roleId) {
        if (userId == null || userId < 1L || roleId == null || roleId < 1L) {
            return false;
        }

        if (!userRoleRepository.existsByUserIdAndRoleId(userId, roleId)) {
            return false;
        }
        return userRoleRepository.delete(userId, roleId);
    }

    @Override
    public List<UserRole> findByUserId(Long userId) {
        if (userId == null || userId < 1L) {
            return List.of();
        }
        return userRoleRepository.findByUserId(userId);
    }

    @Override
    public List<UserRole> findByRoleId(Long roleId) {
        if (roleId == null || roleId < 1L) {
            return List.of();
        }
        return userRoleRepository.findByRoleId(roleId);
    }

    @Override
    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public boolean existsByUserIdAndRoleId(Long userId, Long roleId) {
        if (userId == null || userId < 1L || roleId == null || roleId < 1L) {
            return false;
        }
        return userRoleRepository.existsByUserIdAndRoleId(userId, roleId);
    }

    private boolean isInvalidUserRole(UserRole userRole) {

        return userRole.getUserId() == null || userRole.getUserId() < 1L
                || userRole.getRoleId() == null || userRole.getRoleId() < 1L;
    }
}