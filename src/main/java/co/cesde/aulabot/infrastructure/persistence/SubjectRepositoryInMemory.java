package co.cesde.aulabot.infrastructure.persistence;

import co.cesde.aulabot.domain.models.Subject;
import co.cesde.aulabot.domain.repository.SubjectRepository;

import java.util.ArrayList;
import java.util.List;

public class SubjectRepositoryInMemory implements SubjectRepository {
  private List<Subject> subjects;
  private Long nextSubjectId;

  public SubjectRepositoryInMemory() {
   this.subjects = new ArrayList<>();
   this.nextSubjectId = 1L;
  }

  @Override
  public Subject create(Subject subject) {
    if (subject == null) {
      return null;
    }
    subject.setSubjectId(nextSubjectId++);
    subjects.add(subject);
    return subject;
  }

  @Override
  public boolean delete(Long subjectId) {
    if (subjectId == null) {
      return false;
    }
    Subject subject = findById(subjectId);
    if (subject == null) {
      return false;
    }
    return subjects.remove(subject);
  }

  @Override
  public boolean update(Subject subjectUpdate) {
    if (subjectUpdate == null || subjectUpdate.getSubjectId() == null) {
      return false;
    }
    for (Subject subject : subjects) {
      if (!subject.getSubjectId().equals(subjectUpdate.getSubjectId()) && subject.getCode().equals(subjectUpdate.getCode())) {
        return false;
      }
    }
    for (int i = 0; i < subjects.size(); i++) {
      if (subjects.get(i).getSubjectId().equals(subjectUpdate.getSubjectId())) {
        subjects.set(i, subjectUpdate);
        return true;
      }
    }
    return false;
  }

  @Override
  public Subject findById(Long subjectId) {
    if (subjectId == null || subjectId < 0L) {
      return null;
    }
    for (Subject subject : subjects) {
      if (subject.getSubjectId().equals(subjectId)) {
        return subject;
      }
    }
    return null;
  }

  @Override
  public List<Subject> findAll() {
    return List.of(subjects.toArray(new Subject[0]));
  }

  @Override
  public Subject findByCode(String code) {
    if (code == null || code.isBlank()) {
      return null;
    }
    for (Subject subject : subjects) {
      if (subject.getCode().equals(code)) {
        return subject;
      }
    }
    return null;
  }

  @Override
  public List<Subject> findByProgramId(Long programId) {
    if (programId == null || programId < 0L) {
      return new ArrayList<>();
    }
    List<Subject> result = new ArrayList<>();
    for (Subject subject : subjects) {
      if (subject.getProgramId().equals(programId)) {
        result.add(subject);
      }
    }
    return result;
  }

  @Override
  public boolean existsByCode(String code) {
    return findByCode(code) != null;
  }
}
