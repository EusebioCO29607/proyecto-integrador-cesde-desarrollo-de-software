package co.cesde.aulabot.application.mapper;

import co.cesde.aulabot.application.dto.EnrollmentRequest;
import co.cesde.aulabot.domain.models.Enrollment;

public class EnrollmentMapper {

    public Enrollment toEntity(EnrollmentRequest request) {
        if (request == null) {
            return null;
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setStudentId(request.getStudentId());
        enrollment.setGroupId(request.getGroupId());
        enrollment.setPeriodId(request.getPeriodId());

        return enrollment;
    }

    public EnrollmentRequest toDto(Enrollment entity) {
        if (entity == null) {
            return null;
        }

        EnrollmentRequest request = new EnrollmentRequest();
        request.setStudentId(entity.getStudentId());
        request.setGroupId(entity.getGroupId());
        request.setPeriodId(entity.getPeriodId());

        return request;
    }
}
