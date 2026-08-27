package co.cesde.aulabot.application.mapper;

import co.cesde.aulabot.application.dto.RoleRequest;
import co.cesde.aulabot.domain.models.Role;

public class RoleMapper {

    public Role toEntity(RoleRequest request) {
        if (request == null) {
            return null;
        }

        Role role = new Role();
        role.setName(request.getName());
        role.setDescription(request.getDescription());

        return role;
    }

    public RoleRequest toDto(Role entity) {
        if (entity == null) {
            return null;
        }

        RoleRequest request = new RoleRequest();
        request.setName(entity.getName());
        request.setDescription(entity.getDescription());

        return request;
    }
}

