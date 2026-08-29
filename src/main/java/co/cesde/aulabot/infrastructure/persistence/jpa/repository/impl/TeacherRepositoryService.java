package co.cesde.aulabot.infrastructure.persistence.jpa.repository.impl;

import co.cesde.aulabot.domain.models.Teacher;
import co.cesde.aulabot.domain.repository.TeacherRepository;
import co.cesde.aulabot.infrastructure.persistence.jpa.repository.JpaTeacherRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public abstract class TeacherRepositoryService implements TeacherRepository {

  private final JpaTeacherRepository jpaTeacherRepository;

  public TeacherRepositoryService(JpaTeacherRepository jpaTeacherRepository) {
    this.jpaTeacherRepository = jpaTeacherRepository;
  }

  @Override
  public Teacher create(Teacher teacher) {
    if (teacher == null) {
      throw new IllegalArgumentException("Teacher cannot be null");
    }
    if (existsByDocumentNumber(teacher.getDocumentNumber())) {
      throw new IllegalArgumentException("Teacher with document number " + teacher.getDocumentNumber() + " already exists");
    }
    return jpaTeacherRepository.save(teacher);
  }

  @Override
  public boolean delete(Long teacherId) {
    if (teacherId == null || jpaTeacherRepository.findById(teacherId).isEmpty()) {
      return false;
    }
    jpaTeacherRepository.deleteById(teacherId);
    return true;
  }

  @Override
  public boolean update(Teacher teacherUpdate) {
    if (teacherUpdate == null || teacherUpdate.getTeacherId() == null) {
      return false;
    }
    if (jpaTeacherRepository.findById(teacherUpdate.getTeacherId()).isEmpty()) {
      return false;
    }
    jpaTeacherRepository.save(teacherUpdate);
    return true;
  }

  @Override
  public Teacher findById(Long teacherId) {
    return jpaTeacherRepository.findById(teacherId).orElse(null);
  }

  @Override
  public Teacher findByDocumentNumber(String documentNumber) {
    return jpaTeacherRepository.findByDocumentNumber(documentNumber).orElse(null);
  }

  @Override
  public List<Teacher> findAll() {
    return jpaTeacherRepository.findAll();
  }

  @Override
  public boolean existsByDocumentNumber(String documentNumber) {
    return jpaTeacherRepository.existsByDocumentNumber(documentNumber);
  }
}