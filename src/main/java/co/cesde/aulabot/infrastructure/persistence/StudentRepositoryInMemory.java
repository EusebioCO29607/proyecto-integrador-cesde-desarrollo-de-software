package co.cesde.aulabot.infrastructure.persistence;

import co.cesde.aulabot.domain.models.Student;
import co.cesde.aulabot.domain.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryInMemory implements StudentRepository {
  private List<Student> students;
  private Long nextStudentId;

  public StudentRepositoryInMemory() {
    this.students = new ArrayList<>();
    this.nextStudentId = 1L;
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
  public boolean delete(Long studentId) {
    if (studentId == null) {
      return false;
    }
    Student student = findById(studentId);
    if (student == null) {
      return false;
    }
    return students.remove(student);
  }

  @Override
  public boolean update(Student studentUpdate) {
    if (studentUpdate == null || studentUpdate.getStudentId() == null) {
      return false;
    }
    for (Student student : students) {
      if (!student.getStudentId().equals(studentUpdate.getStudentId()) && student.getDocumentNumber().equals(studentUpdate.getDocumentNumber())) {
        return false;
      }
    }
    for (int i = 0; i < students.size(); i++) {
      if (students.get(i).getStudentId().equals(studentUpdate.getStudentId())) {
        students.set(i, studentUpdate);
        return true;
      }
    }
    return false;
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

}
