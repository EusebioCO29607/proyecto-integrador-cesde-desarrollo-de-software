package co.cesde.aulabot.infrastructure.persistence.jpa.repository.impl;

import co.cesde.aulabot.domain.models.Grade;
import co.cesde.aulabot.domain.repository.GradeRepository;
import co.cesde.aulabot.infrastructure.persistence.jpa.repository.JpaGradeRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public abstract class GradeRepositoryService implements GradeRepository {

  private final JpaGradeRepository jpaGradeRepository;

  public GradeRepositoryService(JpaGradeRepository jpaGradeRepository) {
    this.jpaGradeRepository = jpaGradeRepository;
  }

  @Override
  public Grade create(Grade grade) {
    if (grade == null) {
      throw new IllegalArgumentException("Grade cannot be null");
    }
    return jpaGradeRepository.save(grade);
  }

  @Override
  public boolean delete(Long gradeId) {
    if (gradeId == null || jpaGradeRepository.findById(gradeId).isEmpty()) {
      return false;
    }
    jpaGradeRepository.deleteById(gradeId);
    return true;
  }

  @Override
  public boolean update(Grade gradeUpdate) {
    if (gradeUpdate == null || gradeUpdate.getGradeId() == null) {
      return false;
    }
    if (jpaGradeRepository.findById(gradeUpdate.getGradeId()).isEmpty()) {
      return false;
    }
    jpaGradeRepository.save(gradeUpdate);
    return true;
  }

  @Override
  public Grade findById(Long gradeId) {
    return jpaGradeRepository.findById(gradeId).orElse(null);
  }

  @Override
  public List<Grade> findByStudentId(Long studentId) {
    return jpaGradeRepository.findByStudentId(studentId);
  }

  @Override
  public List<Grade> findByGroupSubjectId(Long groupSubjectId) {
    return jpaGradeRepository.findByGroupSubjectId(groupSubjectId);
  }

  @Override
  public List<Grade> findAll() {
    return jpaGradeRepository.findAll();
  }
}