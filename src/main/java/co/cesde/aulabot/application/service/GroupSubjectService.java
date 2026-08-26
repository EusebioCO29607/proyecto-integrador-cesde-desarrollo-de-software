package co.cesde.aulabot.application.service;

import co.cesde.aulabot.domain.models.GroupSubject;

import java.util.List;

public interface GroupSubjectService {

  GroupSubject create(GroupSubject groupSubject);

  boolean update(GroupSubject groupSubjectUpdate);

  boolean delete(Long groupSubjectId);

  List<GroupSubject> findByGroupId(Long groupId);

  List<GroupSubject> findBySubjectId(Long subjectId);

  List<GroupSubject> findByTeacherId(Long teacherId);

  List<GroupSubject> findAll();

}
