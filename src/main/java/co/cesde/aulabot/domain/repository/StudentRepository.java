package co.cesde.aulabot.domain.repository;

import co.cesde.aulabot.domain.models.Student;

import java.util.List;

public interface StudentRepository {
  Student create(Student student);

  boolean delete(Long studentId);

  boolean update(Student studentUpdate);

  Student findById(Long studentId);

  Student findByDocumentNumber(String documentNumber);

  List<Student> findAll();

  boolean existsByDocumentNumber(String documentNumber);
}
