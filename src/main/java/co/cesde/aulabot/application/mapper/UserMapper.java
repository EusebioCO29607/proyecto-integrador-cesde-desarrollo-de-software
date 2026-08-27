package co.cesde.aulabot.application.mapper;

import co.cesde.aulabot.application.dto.UserRequest;
import co.cesde.aulabot.domain.models.User;

public class UserMapper {

    public User toEntity(UserRequest request) {
        if (request == null) {
            return null;
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPasswordHash(request.getPassword()); // Mapea password a passwordHash

        return user;
    }

    public UserRequest toDto(User entity) {
        if (entity == null) {
            return null;
        }

        UserRequest request = new UserRequest();
        request.setUsername(entity.getUsername());
        request.setEmail(entity.getEmail());
        request.setPassword(entity.getPasswordHash());

        return request;
    }
}