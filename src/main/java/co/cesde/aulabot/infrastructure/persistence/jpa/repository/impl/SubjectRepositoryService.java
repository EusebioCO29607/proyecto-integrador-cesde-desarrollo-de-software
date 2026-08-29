package co.cesde.aulabot.infrastructure.persistence.jpa.repository.impl;

import co.cesde.aulabot.domain.models.Subject;
import co.cesde.aulabot.domain.repository.SubjectRepository;
import co.cesde.aulabot.infrastructure.persistence.jpa.repository.JpaSubjectRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public abstract class SubjectRepositoryService implements SubjectRepository {

  private final JpaSubjectRepository jpaSubjectRepository;

  public SubjectRepositoryService(JpaSubjectRepository jpaSubjectRepository) {
    this.jpaSubjectRepository = jpaSubjectRepository;
  }

  @Override
  public Subject create(Subject subject) {
    if (subject == null) {
      throw new IllegalArgumentException("Subject cannot be null");
    }
    if (existsByCode(subject.getCode())) {
      throw new IllegalArgumentException("Subject with code " + subject.getCode() + " already exists");
    }
    return jpaSubjectRepository.save(subject);
  }

  @Override
  public boolean delete(Long subjectId) {
    if (subjectId == null || jpaSubjectRepository.findById(subjectId).isEmpty()) {
      return false;
    }
    jpaSubjectRepository.deleteById(subjectId);
    return true;
  }

  @Override
  public boolean update(Subject subjectUpdate) {
    if (subjectUpdate == null || subjectUpdate.getSubjectId() == null) {
      return false;
    }
    if (jpaSubjectRepository.findById(subjectUpdate.getSubjectId()).isEmpty()) {
      return false;
    }
    jpaSubjectRepository.save(subjectUpdate);
    return true;
  }

  @Override
  public Subject findById(Long subjectId) {
    return jpaSubjectRepository.findById(subjectId).orElse(null);
  }

  @Override
  public List<Subject> findByProgramId(Long programId) {
    return jpaSubjectRepository.findByProgramId(programId);
  }

  @Override
  public List<Subject> findAll() {
    return jpaSubjectRepository.findAll();
  }

  @Override
  public boolean existsByCode(String code) {
    return jpaSubjectRepository.existsByCode(code);
  }
}