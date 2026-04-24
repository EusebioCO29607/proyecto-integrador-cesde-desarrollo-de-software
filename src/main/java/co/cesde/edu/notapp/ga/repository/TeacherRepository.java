package co.cesde.edu.notapp.ga.repository;

import co.cesde.edu.notapp.ga.models.Teacher;

import java.util.List;

public interface TeacherRepository {
  Teacher create(Teacher teacher);

  boolean update(Teacher teacher);

  boolean delete(Long teacherId);

  Teacher findById(Long teacherId);

  List<Teacher> findAll();

  Teacher findByDocumentNumber(String documentNumber);

  boolean existsByDocumentNumber(String documentNumber);
}
