package co.cesde.edu.notapp.ga.service;

import co.cesde.edu.notapp.ga.models.Student;

import java.util.List;

public interface StudentService {
  Student create(Student student);

  boolean update(Student studentUpdate);

  boolean delete(Long StudentId);

  Student findByDocumentNumber(String documentNumber);

  List<Student> findAll();
}
