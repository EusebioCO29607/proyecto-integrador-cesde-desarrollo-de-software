package co.cesde.aulabot.infrastructure.persistence.jpa.repository.impl;

import co.cesde.aulabot.domain.models.Group;
import co.cesde.aulabot.domain.repository.GroupRepository;
import co.cesde.aulabot.infrastructure.persistence.jpa.repository.JpaGroupRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public abstract class GroupRepositoryService implements GroupRepository {

  private final JpaGroupRepository jpaGroupRepository;

  public GroupRepositoryService(JpaGroupRepository jpaGroupRepository) {
    this.jpaGroupRepository = jpaGroupRepository;
  }

  @Override
  public Group create(Group group) {
    if (group == null) {
      throw new IllegalArgumentException("Group cannot be null");
    }
    if (existsByCode(group.getCode())) {
      throw new IllegalArgumentException("Group with code " + group.getCode() + " already exists");
    }
    return jpaGroupRepository.save(group);
  }

  @Override
  public boolean delete(Long groupId) {
    if (groupId == null || jpaGroupRepository.findById(groupId).isEmpty()) {
      return false;
    }
    jpaGroupRepository.deleteById(groupId);
    return true;
  }

  @Override
  public boolean update(Group groupUpdate) {
    if (groupUpdate == null || groupUpdate.getGroupId() == null) {
      return false;
    }
    if (jpaGroupRepository.findById(groupUpdate.getGroupId()).isEmpty()) {
      return false;
    }
    jpaGroupRepository.save(groupUpdate);
    return true;
  }

  @Override
  public Group findById(Long groupId) {
    return jpaGroupRepository.findById(groupId).orElse(null);
  }

  @Override
  public List<Group> findByProgramId(Long programId) {
    return jpaGroupRepository.findByProgramId(programId);
  }

  @Override
  public List<Group> findByPeriodId(Long periodId) {
    return jpaGroupRepository.findByPeriodId(periodId);
  }

  @Override
  public List<Group> findAll() {
    return jpaGroupRepository.findAll();
  }

  @Override
  public boolean existsByCode(String code) {
    return jpaGroupRepository.existsByCode(code);
  }
}