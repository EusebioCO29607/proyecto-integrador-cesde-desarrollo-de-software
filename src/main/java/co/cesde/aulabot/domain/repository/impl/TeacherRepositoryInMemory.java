package co.cesde.aulabot.domain.repository.impl;

import co.cesde.aulabot.domain.models.Teacher;
import co.cesde.aulabot.domain.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepositoryInMemory implements TeacherRepository {

  private List<Teacher> teachers;
  private Long nextTeacherId;

  public TeacherRepositoryInMemory() {
    this.teachers = new ArrayList<>();
    this.nextTeacherId = 1L;
  }

  @Override
  public Teacher create(Teacher teacher) {
    if (teacher ==  null) {
      return null;
    }
    teacher.setTeacherId(nextTeacherId++);
    teachers.add(teacher);
    return teacher;
  }

  @Override
  public boolean delete(Long teacherId) {
    if (teacherId == null) {
      return false;
    }
    Teacher teacher = findById(teacherId);
    if (teacher == null) {
      return false;
    }
    return teachers.remove(teacher);
  }

  @Override
  public boolean update(Teacher teacherUpdate) {
    if (teacherUpdate == null || teacherUpdate.getTeacherId() == null) {
      return false;
    }
    for (Teacher teacher : teachers) {
      if (!teacherUpdate.getTeacherId().equals(teacher.getTeacherId()) && teacher.getDocumentNumber().equals(teacherUpdate.getDocumentNumber())) {
        return false;
      }
    }
    for (int i = 0; i < teachers.size(); i++) {
      if(teachers.get(i).getTeacherId().equals(teacherUpdate.getTeacherId())) {
        teachers.set(i, teacherUpdate);
        return true;
      }
    }
    return false;
  }

  @Override
  public Teacher findById(Long teacherId) {
    if (teacherId == null || teacherId < 0L) {
      return null;
    }
    for (Teacher teacher : teachers) {
      if (teacher.getTeacherId().equals(teacherId)) {
        return teacher;
      }
    }
    return null;
  }

  @Override
  public Teacher findByDocumentNumber(String documentNumber) {
    if  (documentNumber == null || documentNumber.isBlank()) {
      return null;
    }
    for (Teacher teacher : teachers) {
      if (teacher.getDocumentNumber().equals(documentNumber)) {
        return teacher;
      }
    }
    return null;
  }

  @Override
  public List<Teacher> findAll() {
    return List.of(teachers.toArray(new Teacher[0]));
  }

  @Override
  public boolean existsByDocumentNumber(String documentNumber) {
    return findByDocumentNumber(documentNumber) != null;
  }
}
