package co.cesde.aulabot.domain.repository;

import co.cesde.aulabot.domain.models.Student;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface StudentRepository {
  Student save(Student student);

  Student create(Student student);

  void delete(Long studentId);

  Optional<Student> update(Student studentUpdate);

  Student findById(Long studentId);

  Student findByDocumentNumber(String documentNumber);

  List<Student> findAll();

  boolean existsByDocumentNumber(String documentNumber);
  
  boolean existsByStudentId(Long studentId);

  Optional<Student> findByStudentId(Long studentId);
}
