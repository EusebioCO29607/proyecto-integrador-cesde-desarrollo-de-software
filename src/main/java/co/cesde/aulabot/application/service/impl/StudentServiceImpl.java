package co.cesde.aulabot.application.service.impl;

import co.cesde.aulabot.application.Exceptions.StudentNotFoundException;
import co.cesde.aulabot.domain.models.Student;
import co.cesde.aulabot.domain.repository.StudentRepository;
import co.cesde.aulabot.application.service.StudentService;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements StudentService {
  private final StudentRepository studentRepository;

  public StudentServiceImpl(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Override
  public Student save(Student student) {
    if (isInvalidStudent(student) || studentRepository.existsByDocumentNumber(student.getDocumentNumber())) {
      return null;
    }
    return studentRepository.save(student);
  }

  @Override
  public Optional<Student> update(Student studentUpdate) {
    if (studentUpdate == null || studentUpdate.getStudentId() == null) {
      throw  new StudentNotFoundException(studentUpdate.getStudentId());
    }
    if (isInvalidStudent(studentUpdate)) {
      throw  new StudentNotFoundException(studentUpdate.getStudentId());
    }
    Student student = studentRepository.findById(studentUpdate.getStudentId());
    if (student == null) {
      throw  new StudentNotFoundException(studentUpdate.getStudentId());
    }
    if (!student.getDocumentNumber().equals(studentUpdate.getDocumentNumber()) && studentRepository.existsByDocumentNumber(studentUpdate.getDocumentNumber())) {
      throw  new StudentNotFoundException(studentUpdate.getStudentId());
    }
    return studentRepository.update(studentUpdate);
  }

  @Override
  public void delete(Long studentId) {
    if (studentRepository.existsByStudentId(studentId)) {
      throw new StudentNotFoundException("Not student found" + studentId);
    }
    studentRepository.existsByStudentId(studentId);
  }

  @Override
  public Optional<Student> findByStudentId(Long studentId) {
    if (studentRepository.findByStudentId(studentId).isEmpty()) {
      throw new StudentNotFoundException("Not student found" + studentId);
    }
    return studentRepository.findByStudentId(studentId);
  }

  @Override
  public Student findByDocumentNumber(String documentNumber) {
    if (documentNumber == null || documentNumber.isBlank()) {
      return null;
    }
    return studentRepository.findByDocumentNumber(documentNumber);
  }

  @Override
  public List<Student> findAll() {
    return studentRepository.findAll();
  }

  @Override
  public boolean existsByStudentId(Long studentId) {
    if (studentRepository.findByStudentId(studentId).isEmpty()) {
      throw new StudentNotFoundException("Not student found" + studentId);
    }
    return studentRepository.existsByStudentId(studentId);
  }

  private boolean isInvalidStudent(Student student) {
    return student.getStudentId() == null
        || !isNotBlank(student.getCode())
        || !isNotBlank(student.getDocumentNumber())
        || !isNotBlank(student.getFirstName())
        || !isNotBlank(student.getLastName())
        || student.getStatus() == null
        || !isNotBlank(student.getBirthDate());
  }

  private boolean isNotBlank(String value) {
    return value != null && !value.isBlank();
  }
}
