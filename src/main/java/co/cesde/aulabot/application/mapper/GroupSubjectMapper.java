package co.cesde.aulabot.application.mapper;

import co.cesde.aulabot.application.dto.GroupSubjectRequest;
import co.cesde.aulabot.domain.models.GroupSubject;

public class GroupSubjectMapper {

    public GroupSubject toEntity(GroupSubjectRequest request) {
        if (request == null) {
            return null;
        }

        GroupSubject groupSubject = new GroupSubject();
        groupSubject.setGroupId(request.getGroupId());
        groupSubject.setSubjectId(request.getSubjectId());
        groupSubject.setTeacherId(request.getTeacherId());

        return groupSubject;
    }

    public GroupSubjectRequest toDto(GroupSubject entity) {
        if (entity == null) {
            return null;
        }

        GroupSubjectRequest request = new GroupSubjectRequest();
        request.setGroupId(entity.getGroupId());
        request.setSubjectId(entity.getSubjectId());
        request.setTeacherId(entity.getTeacherId());

        return request;
    }
}
