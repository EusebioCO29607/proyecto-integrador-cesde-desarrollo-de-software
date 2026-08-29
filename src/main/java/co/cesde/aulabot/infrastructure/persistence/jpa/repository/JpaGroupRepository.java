package co.cesde.aulabot.infrastructure.persistence.jpa.repository;

import co.cesde.aulabot.domain.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaGroupRepository extends JpaRepository<Group, Long> {

  Group save(Group group);

  Optional<Group> findByGroupId(Long groupId);

  List<Group> findByProgramId(Long programId);

  List<Group> findByPeriodId(Long periodId);

  boolean existsByCode(String code);

  List<Group> findAll();

}
