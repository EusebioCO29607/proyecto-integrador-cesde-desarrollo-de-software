package co.cesde.aulabot.domain.repository.impl;

import co.cesde.aulabot.domain.models.Group;
import co.cesde.aulabot.domain.repository.GroupRepository;

import java.util.ArrayList;
import java.util.List;

public class GroupRepositoryInMemory implements GroupRepository {
  private List<Group> groups;
  private Long nextGroupId;

  public GroupRepositoryInMemory() {
    this.groups = new ArrayList<>();
    this.nextGroupId = 1L;
  }

  @Override
  public Group create(Group group) {
    if (group == null) {
      return null;
    }
    group.setGroupId(nextGroupId++);
    groups.add(group);
    return group;
  }

  @Override
  public boolean delete(Long groupId) {
    if (groupId == null) {
      return false;
    }
    Group group = findById(groupId);
    if (group == null) {
      return false;
    }
    return groups.remove(group);
  }

  @Override
  public boolean update(Group groupUpdate) {
    if (groupUpdate == null || groupUpdate.getGroupId() == null) {
      return false;
    }
    for (Group group : groups) {
      if (!group.getGroupId().equals(groupUpdate.getGroupId()) && group.getCode().equals(groupUpdate.getCode())) {
        return false;
      }
    }
    for (int i = 0; i < groups.size(); i++) {
      if (groups.get(i).getGroupId().equals(groupUpdate.getGroupId())) {
        groups.set(i, groupUpdate);
        return true;
      }
    }
    return false;
  }

  @Override
  public Group findById(Long groupId) {
    if (groupId == null || groupId < 0L) {
      return null;
    }
    for (Group group : groups) {
      if (group.getGroupId().equals(groupId)) {
        return group;
      }
    }
    return null;
  }

  @Override
  public List<Group> findByProgramId(Long programId) {
    List<Group> result = new ArrayList<>();
    if (programId == null) {
      return result;
    }
    for (Group group : groups) {
      if (group.getProgramId() != null && group.getProgramId().equals(programId)) {
        result.add(group);
      }
    }
    return result;
  }

  @Override
  public List<Group> findByPeriodId(Long periodId) {
    List<Group> result = new ArrayList<>();
    if (periodId == null) {
      return result;
    }
    for (Group group : groups) {
      if (group.getPeriodId() != null && group.getPeriodId().equals(periodId)) {
        result.add(group);
      }
    }
    return result;
  }

  @Override
  public List<Group> findAll() {
    return List.of(groups.toArray(new Group[0]));
  }

  @Override
  public boolean existsByCode(String code) {
    if (code == null || code.isBlank()) {
      return false;
    }
    for (Group group : groups) {
      if (group.getCode().equals(code)) {
        return true;
      }
    }
    return false;
  }

}