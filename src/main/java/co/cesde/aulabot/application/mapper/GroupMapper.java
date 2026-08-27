package co.cesde.aulabot.application.mapper;
import co.cesde.aulabot.application.dto.GroupRequest;
import co.cesde.aulabot.domain.models.Group;

public class GroupMapper {

    public Group toEntity(GroupRequest request) {
        if (request == null) {
            return null;
        }

        Group group = new Group();
        group.setCode(request.getCode());
        group.setProgramId(request.getProgramId());
        group.setPeriodId(request.getPeriodId());
        group.setShift(request.getShift());

        return group;
    }

    public GroupRequest toDto(Group entity) {
        if (entity == null) {
            return null;
        }

        GroupRequest request = new GroupRequest();
        request.setCode(entity.getCode());
        request.setProgramId(entity.getProgramId());
        request.setPeriodId(entity.getPeriodId());
        request.setShift(entity.getShift());

        return request;
    }
}