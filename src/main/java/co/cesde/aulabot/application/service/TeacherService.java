package co.cesde.aulabot.application.service;

import co.cesde.aulabot.domain.models.Teacher;

import java.util.List;

public interface TeacherService {

  List<Teacher> findAll();

  Teacher getTeacher(Long teacherId);

  Teacher create(Teacher teacher);

  Teacher findByDocumentNumber(String documentNumber);

  boolean update (Teacher teacher);

  boolean delete (Long teacherId);
}
