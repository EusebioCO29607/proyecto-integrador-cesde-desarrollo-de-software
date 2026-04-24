package co.cesde.edu.notapp.ga.service;

import co.cesde.edu.notapp.ga.models.Teacher;

import java.util.List;

public interface TeacherService {

  List<Teacher> findAll();

  Teacher create(Teacher teacher);

  Teacher findByDocumentNumber(String documentNumber);

  boolean update (Teacher teacher);

  boolean delete (Long teacherId);
}
