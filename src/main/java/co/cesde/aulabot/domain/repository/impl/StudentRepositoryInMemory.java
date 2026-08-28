package co.cesde.aulabot.domain.repository.impl;

import co.cesde.aulabot.domain.models.Student;
import co.cesde.aulabot.domain.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRepositoryInMemory implements StudentRepository {
  private List<Student> students;
  private Long nextStudentId;

  public StudentRepositoryInMemory() {
    this.students = new ArrayList<>();
    this.nextStudentId = 1L;
  }

  @Override
  public Student save(Student student) {
    if (student == null) {
      throw new IllegalArgumentException("Student cannot be null");
    }
    if (student.getStudentId() != null && findById(student.getStudentId()) != null) {
      throw new RuntimeException("Student with id " + student.getStudentId() + " already exists");
    }
    if (existsByDocumentNumber(student.getDocumentNumber())) {
      throw new RuntimeException("Student with document number " + student.getDocumentNumber() + " already exists");
    }
    student.setStudentId(nextStudentId++);
    students.add(student);
    return student;
  }

  @Override
  public Student create(Student student) {
    if (student == null) {
      return null;
    }
    student.setStudentId(nextStudentId++);
    students.add(student);
    return student;
  }

  @Override
  public void delete(Long studentId) {
    Student student = findById(studentId);
    students.remove(student);
  }

  @Override
  public Optional<Student> update(Student studentUpdate) {
    if (studentUpdate == null || studentUpdate.getStudentId() == null) {
      return Optional.empty();
    }
    for (Student student : students) {
      if (!student.getStudentId().equals(studentUpdate.getStudentId()) && student.getDocumentNumber().equals(studentUpdate.getDocumentNumber())) {
        return Optional.empty();
      }
    }
    for (int i = 0; i < students.size(); i++) {
      if (students.get(i).getStudentId().equals(studentUpdate.getStudentId())) {
        students.set(i, studentUpdate);
        return Optional.of(studentUpdate);
      }
    }
    return Optional.empty();
  }
  @Override
  public Student findById(Long studentId) {
    if (studentId == null || studentId < 0L) {
      return null;
    }
    for (Student student : students) {
      if (student.getStudentId().equals(studentId)) {
        return student;
      }
    }
    return null;
  }
  @Override
  public Student findByDocumentNumber(String documentNumber) {
    if (documentNumber == null || documentNumber.isBlank()) {
      return null;
    }
    for (Student student : students) {
      if (student.getDocumentNumber().equals(documentNumber)) {
        return student;
      }
    }
    return null;
  }

  @Override
  public List<Student> findAll() {
    return List.of(students.toArray(new Student[0])); //return new ArrayList<>(students);
  }

  @Override
  public boolean existsByDocumentNumber(String documentNumber) {
    return findByDocumentNumber(documentNumber) != null;
  }

  @Override
  public boolean existsByStudentId(Long studentId) {
    return false;
  }

  @Override
  public Optional<Student> findByStudentId(Long studentId) {
    return Optional.empty();
  }

}