package co.cesde.aulabot.infrastructure.persistence;

import co.cesde.aulabot.domain.models.GroupSubject;
import co.cesde.aulabot.domain.repository.GroupSubjectRepository;

import java.util.ArrayList;
import java.util.List;

public class GroupSubjectRepositoryInMemory implements GroupSubjectRepository {

  private List<GroupSubject> groupSubjects;
  private Long nextGroupSubjectId;

  public GroupSubjectRepositoryInMemory() {
    this.groupSubjects = new ArrayList<>();
    this.nextGroupSubjectId = 1L;
  }

  @Override
  public GroupSubject create(GroupSubject groupSubject) {
    if (groupSubject == null) {
      return null;
    }
    groupSubject.setGroupSubjectId(nextGroupSubjectId++);
    groupSubjects.add(groupSubject);
    return groupSubject;
  }

  @Override
  public boolean delete(Long groupSubjectId) {
    if (groupSubjectId == null) {
      return false;
    }
    GroupSubject groupSubject = findById(groupSubjectId);
    if (groupSubject == null) {
      return false;
    }
    return groupSubjects.remove(groupSubject);
  }

  @Override
  public boolean update(GroupSubject groupSubjectUpdate) {
    if (groupSubjectUpdate == null || groupSubjectUpdate.getGroupSubjectId() == null) {
      return false;
    }
    for (int i = 0; i < groupSubjects.size(); i++) {
      if (groupSubjects.get(i).getGroupSubjectId().equals(groupSubjectUpdate.getGroupSubjectId())) {
        groupSubjects.set(i, groupSubjectUpdate);
        return true;
      }
    }
    return false;
  }

  @Override
  public GroupSubject findById(Long groupSubjectId) {
    if (groupSubjectId == null || groupSubjectId < 0L) {
      return null;
    }
    for (GroupSubject groupSubject : groupSubjects) {
      if (groupSubject.getGroupSubjectId().equals(groupSubjectId)) {
        return groupSubject;
      }
    }
    return null;
  }

  @Override
  public List<GroupSubject> findByGroupId(Long groupId) {
    if (groupId == null || groupId < 0L) {
      return new ArrayList<>();
    }
    List<GroupSubject> result = new ArrayList<>();
    for (GroupSubject groupSubject : groupSubjects) {
      if (groupSubject.getGroupId().equals(groupId)) {
        result.add(groupSubject);
      }
    }
    return result;
  }

  @Override
  public List<GroupSubject> findBySubjectId(Long subjectId) {
    if (subjectId == null || subjectId < 0L) {
      return new ArrayList<>();
    }
    List<GroupSubject> result = new ArrayList<>();
    for (GroupSubject groupSubject : groupSubjects) {
      if (groupSubject.getSubjectId().equals(subjectId)) {
        result.add(groupSubject);
      }
    }
    return result;
  }

  @Override
  public List<GroupSubject> findByTeacherId(Long teacherId) {
    if (teacherId == null || teacherId < 0L) {
      return new ArrayList<>();
    }
    List<GroupSubject> result = new ArrayList<>();
    for (GroupSubject groupSubject : groupSubjects) {
      if (groupSubject.getTeacherId().equals(teacherId)) {
        result.add(groupSubject);
      }
    }
    return result;
  }

  @Override
  public List<GroupSubject> findAll() {
    return List.of(groupSubjects.toArray(new GroupSubject[0]));
  }

  @Override
  public boolean existsByGroupIdAndSubjectId(Long groupId, Long subjectId) {
    if (groupId == null || subjectId == null) {
      return false;
    }
    for (GroupSubject groupSubject : groupSubjects) {
      if (groupSubject.getGroupId().equals(groupId)
          && groupSubject.getSubjectId().equals(subjectId)) {
        return true;
      }
    }
    return false;
  }
}

