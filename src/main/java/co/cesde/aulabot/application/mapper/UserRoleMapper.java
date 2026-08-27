package co.cesde.aulabot.application.mapper;

import co.cesde.aulabot.application.dto.UserRoleRequest;
import co.cesde.aulabot.domain.models.UserRole;

public class UserRoleMapper {

    public UserRole toEntity(UserRoleRequest request) {
        if (request == null) {
            return null;
        }

        UserRole userRole = new UserRole();
        userRole.setUserId(request.getUserId());
        userRole.setRoleId(request.getRoleId());

        return userRole;
    }

    public UserRoleRequest toDto(UserRole entity) {
        if (entity == null) {
            return null;
        }

        UserRoleRequest request = new UserRoleRequest();
        request.setUserId(entity.getUserId());
        request.setRoleId(entity.getRoleId());

        return request;
    }
}
