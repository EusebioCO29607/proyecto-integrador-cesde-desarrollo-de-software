package co.cesde.aulabot.infrastructure.persistence.jpa.repository.impl;

import co.cesde.aulabot.domain.models.GroupSubject;
import co.cesde.aulabot.domain.repository.GroupSubjectRepository;
import co.cesde.aulabot.infrastructure.persistence.jpa.repository.JpaGroupSubjectRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public abstract class GroupSubjectRepositoryService implements GroupSubjectRepository {

  private final JpaGroupSubjectRepository jpaGroupSubjectRepository;

  public GroupSubjectRepositoryService(JpaGroupSubjectRepository jpaGroupSubjectRepository) {
    this.jpaGroupSubjectRepository = jpaGroupSubjectRepository;
  }

  @Override
  public GroupSubject create(GroupSubject groupSubject) {
    if (groupSubject == null) {
      throw new IllegalArgumentException("GroupSubject cannot be null");
    }
    return jpaGroupSubjectRepository.save(groupSubject);
  }

  @Override
  public boolean delete(Long groupSubjectId) {
    if (groupSubjectId == null || jpaGroupSubjectRepository.findById(groupSubjectId).isEmpty()) {
      return false;
    }
    jpaGroupSubjectRepository.deleteById(groupSubjectId);
    return true;
  }

  @Override
  public boolean update(GroupSubject groupSubjectUpdate) {
    if (groupSubjectUpdate == null || groupSubjectUpdate.getGroupSubjectId() == null) {
      return false;
    }
    if (jpaGroupSubjectRepository.findById(groupSubjectUpdate.getGroupSubjectId()).isEmpty()) {
      return false;
    }
    jpaGroupSubjectRepository.save(groupSubjectUpdate);
    return true;
  }

  @Override
  public GroupSubject findById(Long groupSubjectId) {
    return jpaGroupSubjectRepository.findById(groupSubjectId).orElse(null);
  }

  @Override
  public List<GroupSubject> findByGroupId(Long groupId) {
    return jpaGroupSubjectRepository.findByGroupId(groupId);
  }

  @Override
  public List<GroupSubject> findByTeacherId(Long teacherId) {
    return jpaGroupSubjectRepository.findByTeacherId(teacherId);
  }

  @Override
  public List<GroupSubject> findAll() {
    return jpaGroupSubjectRepository.findAll();
  }
}