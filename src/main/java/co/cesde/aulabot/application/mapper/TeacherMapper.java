package co.cesde.aulabot.application.mapper;
import co.cesde.aulabot.application.dto.TeacherRequest;
import co.cesde.aulabot.domain.models.Teacher;

public class TeacherMapper {

    public Teacher toEntity(TeacherRequest request) {
        if (request == null) {
            return null;
        }

        Teacher teacher = new Teacher();
        teacher.setFirstName(request.getFirstName());
        teacher.setLastName(request.getLastName());
        teacher.setCode(request.getCode());
        teacher.setUserId(request.getUserId());
        teacher.setDocumentNumber(request.getDocumentNumber());

        return teacher;
    }

    public TeacherRequest toDto(Teacher entity) {
        if (entity == null) {
            return null;
        }

        TeacherRequest request = new TeacherRequest();
        request.setFirstName(entity.getFirstName());
        request.setLastName(entity.getLastName());
        request.setCode(entity.getCode());
        request.setUserId(entity.getUserId());
        request.setDocumentNumber(entity.getDocumentNumber());

        return request;
    }
}
