package co.cesde.aulabot.infrastructure.persistence.jpa.repository;

import co.cesde.aulabot.domain.models.GroupSubject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaGroupSubjectRepository extends JpaRepository<GroupSubject, Long> {

  GroupSubject save(GroupSubject groupSubject);

  List<GroupSubject> findByGroupId(Long groupId);

  List<GroupSubject> findByTeacherId(Long teacherId);

  List<GroupSubject> findAll();

}