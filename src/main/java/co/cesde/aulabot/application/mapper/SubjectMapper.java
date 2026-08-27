package co.cesde.aulabot.application.mapper;
import co.cesde.aulabot.application.dto.SubjectRequest;
import co.cesde.aulabot.domain.models.Subject;

public class SubjectMapper {

    public Subject toEntity(SubjectRequest request) {
        if (request == null) {
            return null;
        }

        Subject subject = new Subject();
        subject.setCode(request.getCode());
        subject.setName(request.getName());
        subject.setCredits(request.getCredits());
        subject.setProgramId(request.getProgramId());

        return subject;
    }

    public SubjectRequest toDto(Subject entity) {
        if (entity == null) {
            return null;
        }

        SubjectRequest request = new SubjectRequest();
        request.setCode(entity.getCode());
        request.setName(entity.getName());
        request.setCredits(entity.getCredits());
        request.setProgramId(entity.getProgramId());

        return request;
    }
}