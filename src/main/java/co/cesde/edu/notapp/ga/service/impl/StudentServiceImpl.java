package co.cesde.edu.notapp.ga.service.impl;

import co.cesde.edu.notapp.ga.exceptions.StudentNotFoundException;
import co.cesde.edu.notapp.ga.models.Student;
import co.cesde.edu.notapp.ga.repository.StudentRepository;
import co.cesde.edu.notapp.ga.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
  private final StudentRepository studentRepository;

  public StudentServiceImpl(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Override
  public Student getStudent(Long studentId){
    for (Student student : studentRepository.findAll()) {
      if (student.getStudentId() == studentId) {
        return student;
      }
    }
    throw new StudentNotFoundException(studentId);
  }

  @Override
  public Student create(Student student) {
    if (isInvalidStudent(student) || studentRepository.existsByDocumentNumber(student.getDocumentNumber())) {
      return null;
    }
    return studentRepository.create(student);
  }

  @Override
  public boolean update(Student studentUpdate) {
    if (studentUpdate == null || studentUpdate.getStudentId() == null) {
      return false;
    }
    if (isInvalidStudent(studentUpdate)) {
      return false;
    }
    Student student = studentRepository.findById(studentUpdate.getStudentId());
    if (student == null) {
      return false;
    }
    if (!student.getDocumentNumber().equals(studentUpdate.getDocumentNumber()) && studentRepository.existsByDocumentNumber(studentUpdate.getDocumentNumber())) {
      return false;
    }
    return studentRepository.update(studentUpdate);
  }

  @Override
  public boolean delete(Long studentId) {
    if (studentId == null) {
      return false;
    }
    Student student = studentRepository.findById(studentId);
    if (student == null) {
      return false;
    }
    return false;
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
