package co.cesde.aulabot.infrastructure.persistence.jpa.repository.impl;

import co.cesde.aulabot.domain.models.Student;
import co.cesde.aulabot.domain.repository.StudentRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
@Service
public abstract class StudentRepositoryService implements StudentRepository {

  private final StudentRepository studentRepository;

  public StudentRepositoryService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }


  @Override
  public Student save(Student student) {
    if (student == null) {
      throw new IllegalArgumentException("Student cannot be null");
    }
    if (existsByStudentId(student.getStudentId())) {
      throw new IllegalArgumentException("Student with id " + student.getStudentId() + " already exists");
    }

    return studentRepository.save(student);
  }

  @Override
  public Student create(Student student) {
    return null;
  }

  @Override
  public void delete(Long studentId) {
    studentRepository.delete(studentId);
  }

  @Override
  public Optional<Student> update(Student studentUpdate) {
    return Optional.empty();
  }

  @Override
  public Student findById(Long studentId) {
    return null;
  }

  @Override
  public Student findByDocumentNumber(String documentNumber) {
    return null;
  }

  @Override
  public List<Student> findAll() {
    return List.of();
  }

  @Override
  public boolean existsByDocumentNumber(String documentNumber) {
    return false;
  }

  @Override
  public boolean existsByStudentId(Long studentId) {
    return studentRepository.existsByStudentId(studentId);
  }

  @Override
  public Optional<Student> findByStudentId(Long studentId) {
    return studentRepository.findByStudentId(studentId);
  }
}
