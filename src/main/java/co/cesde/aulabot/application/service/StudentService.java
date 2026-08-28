package co.cesde.aulabot.application.service;

import co.cesde.aulabot.domain.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
  Student save(Student student);

  Optional<Student> update(Student studentUpdate);

  void delete(Long StudentId);

  Optional<Student> findByStudentId(Long studentId);

  List<Student> findAll();

  boolean existsByStudentId(Long studentId);

  Student findByDocumentNumber(String documentNumber);

}
