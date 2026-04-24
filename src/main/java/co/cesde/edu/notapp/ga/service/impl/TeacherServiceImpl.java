package co.cesde.edu.notapp.ga.service.impl;

import co.cesde.edu.notapp.ga.models.Teacher;
import co.cesde.edu.notapp.ga.repository.TeacherRepository;
import co.cesde.edu.notapp.ga.service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {

  private TeacherRepository teachersRepository;

  public TeacherServiceImpl(TeacherRepository teachersRepository) {
    this.teachersRepository = teachersRepository;
  }

  @Override
  public Teacher create (Teacher teacher) {
    if (isInvalidTeacher(teacher) || teachersRepository.existsByDocumentNumber(teacher.getDocumentNumber())) {
      return null;
    }
    return teachersRepository.create(teacher);
  }

  public boolean update(Teacher teacherUpdate) {
    if (teacherUpdate == null || teacherUpdate.getDocumentNumber() == null) {
      return false;
    }
    if (isInvalidTeacher(teacherUpdate)) {
      return false;
    }
    Teacher teacher = teachersRepository.findById(teacherUpdate.getTeacherId());
    if (teacher == null) {
      return false;
    }
    if (!teacher.getDocumentNumber().equals(teacherUpdate.getDocumentNumber()) &&  teachersRepository.existsByDocumentNumber(teacherUpdate.getDocumentNumber())) {
      return false;
    }
    return teachersRepository.update(teacherUpdate);
  }

  @Override
  public boolean delete(Long teacherId) {
    if  (teacherId == null) {
      return false;
    }
    Teacher teacher = teachersRepository.findById(teacherId);
    if (teacher == null) {
      return false;
    }
    return false;
  }

  @Override
  public Teacher findByDocumentNumber(String documentNumber) {
    if (documentNumber == null || documentNumber.isBlank()) {
      return null;
    }
    return teachersRepository.findByDocumentNumber(documentNumber);
  }

  public List<Teacher> findAll() { return teachersRepository.findAll(); }

  private boolean isInvalidTeacher(Teacher teacher) {
    return teacher.getTeacherId() == null
        || !isNotBlank(teacher.getCode())
        || !isNotBlank(teacher.getDocumentNumber())
        || !isNotBlank(teacher.getFirstName())
        || !isNotBlank(teacher.getLastName())
        || teacher.getStatus() == null;
  }

  private boolean isNotBlank(String value) {
    return value != null && !value.isBlank();
  }
}
