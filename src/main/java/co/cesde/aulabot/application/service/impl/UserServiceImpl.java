package co.cesde.aulabot.application.service.impl;
import co.cesde.aulabot.domain.models.User;
import co.cesde.aulabot.domain.repository.UserRepository;
import co.cesde.aulabot.application.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

        private final UserRepository userRepository;

        public UserServiceImpl(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        @Override
        public User create(User user) {
            if (user == null || isInvalidUser(user)) {
                return null;
            }
            if (userRepository.existsByUsername(user.getUsername()) ||
                    userRepository.existsByEmail(user.getEmail())) {
                return null;
            }
            return userRepository.create(user);
        }

        @Override
        public boolean update(User userUpdate) {
            if (userUpdate == null || userUpdate.getUserId() == null || isInvalidUser(userUpdate)) {
                return false;
            }
            User existing = userRepository.findById(userUpdate.getUserId());
            if (existing == null) {
                return false;
            }


            if (!existing.getUsername().equals(userUpdate.getUsername()) &&
                    userRepository.existsByUsername(userUpdate.getUsername())) {
                return false;
            }
            if (!existing.getEmail().equals(userUpdate.getEmail()) &&
                    userRepository.existsByEmail(userUpdate.getEmail())) {
                return false;
            }

            return userRepository.update(userUpdate);
        }

        @Override
        public boolean delete(Long userId) {
            if (userId == null || userId < 1L) {
                return false;
            }
            User existing = userRepository.findById(userId);
            if (existing == null) {
                return false;
            }
            return userRepository.delete(userId);
        }

        @Override
        public User findById(Long userId) {
            if (userId == null || userId < 1L) {
                return null;
            }
            return userRepository.findById(userId);
        }

        @Override
        public User findByUsername(String username) {
            if (!isNotBlank(username)) {
                return null;
            }
            return userRepository.findByUsername(username);
        }

        @Override
        public List<User> findAll() {
            return userRepository.findAll();
        }

        private boolean isInvalidUser(User user) {
            return !isNotBlank(user.getUsername())
                    || !isNotBlank(user.getEmail())
                    || !isNotBlank(user.getPasswordHash())
                    || !isNotBlank(user.getStatus())
                    || !isNotBlank(user.getCreatedAt());
        }

        private boolean isNotBlank(String value) {
            return value != null && !value.isBlank();
        }
}

