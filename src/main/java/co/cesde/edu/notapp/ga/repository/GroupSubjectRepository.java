package co.cesde.edu.notapp.ga.repository;

import co.cesde.edu.notapp.ga.models.GroupSubject;
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
