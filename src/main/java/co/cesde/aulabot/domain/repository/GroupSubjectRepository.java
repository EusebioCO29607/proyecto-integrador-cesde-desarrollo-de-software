package co.cesde.aulabot.domain.repository;

import co.cesde.aulabot.domain.models.GroupSubject;
import java.util.List;

public interface GroupSubjectRepository {

  GroupSubject create(GroupSubject groupSubject);

  boolean delete(Long groupSubjectId);

  boolean update(GroupSubject groupSubjectUpdate);

  GroupSubject findById(Long groupSubjectId);

  List<GroupSubject> findByGroupId(Long groupId);

  List<GroupSubject> findBySubjectId(Long subjectId);

  List<GroupSubject> findByTeacherId(Long teacherId);

  List<GroupSubject> findAll();

  boolean existsByGroupIdAndSubjectId(Long groupId, Long subjectId);

}
