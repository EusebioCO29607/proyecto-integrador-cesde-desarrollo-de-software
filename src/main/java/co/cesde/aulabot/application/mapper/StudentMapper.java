package co.cesde.aulabot.application.mapper;
import co.cesde.aulabot.application.dto.StudentRequest;
import co.cesde.aulabot.domain.models.Student;

public class StudentMapper {

    public Student toEntity(StudentRequest request) {
        if (request == null) {
            return null;
        }

        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setCode(request.getCode());
        student.setUserId(request.getUserId());
        student.setDocumentNumber(request.getDocumentNumber());
        student.setBirthDate(request.getBirthDate());

        return student;
    }

    public StudentRequest toDto(Student entity) {
        if (entity == null) {
            return null;
        }

        StudentRequest request = new StudentRequest();
        request.setFirstName(entity.getFirstName());
        request.setLastName(entity.getLastName());
        request.setCode(entity.getCode());
        request.setUserId(entity.getUserId());
        request.setDocumentNumber(entity.getDocumentNumber());
        request.setBirthDate(entity.getBirthDate());

        return request;
    }
}