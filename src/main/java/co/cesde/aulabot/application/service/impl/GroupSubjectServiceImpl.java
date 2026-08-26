package co.cesde.aulabot.application.service.impl;

import co.cesde.aulabot.domain.models.GroupSubject;
import co.cesde.aulabot.domain.repository.GroupSubjectRepository;
import co.cesde.aulabot.application.service.GroupSubjectService;

import java.util.List;

public class GroupSubjectServiceImpl implements GroupSubjectService {

  private final GroupSubjectRepository groupSubjectRepository;

  public GroupSubjectServiceImpl(GroupSubjectRepository groupSubjectRepository) {
    this.groupSubjectRepository = groupSubjectRepository;
  }

  @Override
  public GroupSubject create(GroupSubject groupSubject) {
    if (groupSubject == null || isInvalidGroupSubject(groupSubject)) {
      return null;
    }
    if (groupSubjectRepository.existsByGroupIdAndSubjectId(
        groupSubject.getGroupId(), groupSubject.getSubjectId())) {
      return null;
    }
    return groupSubjectRepository.create(groupSubject);
  }

  @Override
  public boolean update(GroupSubject groupSubjectUpdate) {
    if (groupSubjectUpdate == null || groupSubjectUpdate.getGroupSubjectId() == null) {
      return false;
    }
    if (isInvalidGroupSubject(groupSubjectUpdate)) {
      return false;
    }
    GroupSubject groupSubject = groupSubjectRepository.findById(groupSubjectUpdate.getGroupSubjectId());
    if (groupSubject == null) {
      return false;
    }
    boolean groupOrSubjectChanged =
        !groupSubject.getGroupId().equals(groupSubjectUpdate.getGroupId()) ||
            !groupSubject.getSubjectId().equals(groupSubjectUpdate.getSubjectId());

    if (groupOrSubjectChanged && groupSubjectRepository.existsByGroupIdAndSubjectId(
        groupSubjectUpdate.getGroupId(), groupSubjectUpdate.getSubjectId())) {
      return false;
    }
    return groupSubjectRepository.update(groupSubjectUpdate);
  }

  @Override
  public boolean delete(Long groupSubjectId) {
    if (groupSubjectId == null) {
      return false;
    }
    GroupSubject groupSubject = groupSubjectRepository.findById(groupSubjectId);
    if (groupSubject== null) {
      return false;
    }
    return groupSubjectRepository.delete(groupSubjectId);
  }

  @Override
  public List<GroupSubject> findByGroupId(Long groupId) {
    if (groupId == null || groupId < 1L) {
      return List.of();
    }
    return groupSubjectRepository.findByGroupId(groupId);
  }

  @Override
  public List<GroupSubject> findBySubjectId(Long subjectId) {
    if (subjectId == null || subjectId < 1L) {
      return List.of();
    }
    return groupSubjectRepository.findBySubjectId(subjectId);
  }

  @Override
  public List<GroupSubject> findByTeacherId(Long teacherId) {
    if (teacherId == null || teacherId < 1L) {
      return List.of();
    }
    return groupSubjectRepository.findByTeacherId(teacherId);
  }

  @Override
  public List<GroupSubject> findAll() {
    return groupSubjectRepository.findAll();
  }

  private boolean isInvalidGroupSubject(GroupSubject groupSubject) {
    return groupSubject.getGroupId() == null || groupSubject.getGroupId() < 1L
        || groupSubject.getSubjectId() == null || groupSubject.getSubjectId() < 1L
        || groupSubject.getTeacherId() == null || groupSubject.getTeacherId() < 1L;
  }

}
