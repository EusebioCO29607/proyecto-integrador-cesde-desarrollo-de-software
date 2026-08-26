package co.cesde.aulabot.application.service.impl;

import co.cesde.aulabot.domain.models.Subject;
import co.cesde.aulabot.domain.repository.SubjectRepository;
import co.cesde.aulabot.application.service.SubjectService;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {
  private final SubjectRepository subjectRepository;

  public SubjectServiceImpl(SubjectRepository subjectRepository) {
    this.subjectRepository = subjectRepository;
  }

  @Override
  public Subject create(Subject subject) {
    if (subject == null || isInvalidSubject(subject)) {
      return null;
    }
    if (subjectRepository.existsByCode(subject.getCode())) {
      return null;
    }
    return subjectRepository.create(subject);
  }

  @Override
  public boolean update(Subject subjectUpdate) {
    if (subjectUpdate == null || subjectUpdate.getSubjectId() == null) {
      return false;
    }
    if (isInvalidSubject(subjectUpdate)) {
      return false;
    }
    Subject existing = subjectRepository.findById(subjectUpdate.getSubjectId());
    if (existing == null) {
      return false;
    }
    if (!existing.getCode().equals(subjectUpdate.getCode())
        && subjectRepository.existsByCode(subjectUpdate.getCode())) {
      return false;
    }
    return subjectRepository.update(subjectUpdate);
  }

  @Override
  public boolean delete(Long subjectId) {
    if (subjectId == null) {
      return false;
    }
    Subject subject = subjectRepository.findById(subjectId);
    if (subject == null) {
      return false;
    }
    return subjectRepository.delete(subjectId);
  }

  @Override
  public Subject findByCode(String code) {
    if (code == null || code.isBlank()) {
      return null;
    }
    return subjectRepository.findByCode(code);
  }

  @Override
  public List<Subject> findAll() {
    return subjectRepository.findAll();
  }

  @Override
  public List<Subject> findByProgramId(Long programId) {
    if (programId == null || programId < 1L) {
      return List.of();
    }
    return subjectRepository.findByProgramId(programId);
  }


  private boolean isInvalidSubject(Subject subject) {
    return !isNotBlank(subject.getCode())
        || !isNotBlank(subject.getName())
        || subject.getCredits() == null
        || subject.getCredits() < 1
        || subject.getProgramId() == null
        || subject.getProgramId() < 1L;
  }

  private boolean isNotBlank(String value) {
    return value != null && !value.isBlank();
  }
}
