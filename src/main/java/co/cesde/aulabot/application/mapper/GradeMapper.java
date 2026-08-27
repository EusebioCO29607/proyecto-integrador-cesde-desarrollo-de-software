package co.cesde.aulabot.application.mapper;

import co.cesde.aulabot.application.dto.GradeRequest;
import co.cesde.aulabot.domain.models.Grade;

public class GradeMapper {

    public Grade toEntity(GradeRequest request) {
        if (request == null) {
            return null;
        }

        Grade grade = new Grade();
        grade.setGroupSubjectId(request.getGroupSubjectId());
        grade.setStudentId(request.getStudentId());
        grade.setFinalScore(request.getFinalScore());
        grade.setObservation(request.getObservation());

        return grade;
    }

    public GradeRequest toDto(Grade entity) {
        if (entity == null) {
            return null;
        }

        GradeRequest request = new GradeRequest();
        request.setGroupSubjectId(entity.getGroupSubjectId());
        request.setStudentId(entity.getStudentId());
        request.setFinalScore(entity.getFinalScore());
        request.setObservation(entity.getObservation());

        return request;
    }
}