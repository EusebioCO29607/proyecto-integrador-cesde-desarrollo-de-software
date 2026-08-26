package co.cesde.aulabot.application.service;

import co.cesde.aulabot.domain.models.Student;

import java.util.List;

public interface StudentService {
  Student create(Student student);

  boolean update(Student studentUpdate);

  boolean delete(Long StudentId);

  Student findByDocumentNumber(String documentNumber);

  List<Student> findAll();

  Student getStudent(Long studentId);
}
