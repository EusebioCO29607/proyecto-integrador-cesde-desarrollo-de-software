package co.cesde.aulabot.infrastructure.persistence.jpa.repository;

import co.cesde.aulabot.domain.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaSubjectRepository extends JpaRepository<Subject, Long> {

  Subject save(Subject subject);

  List<Subject> findByProgramId(Long programId);

  boolean existsByCode(String code);

  List<Subject> findAll();

}