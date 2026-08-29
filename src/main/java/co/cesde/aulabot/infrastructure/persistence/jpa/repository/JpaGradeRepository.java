package co.cesde.aulabot.infrastructure.persistence.jpa.repository;

import co.cesde.aulabot.domain.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaGradeRepository extends JpaRepository<Grade, Long> {

  Grade save(Grade grade);

  List<Grade> findByStudentId(Long studentId);

  List<Grade> findByGroupSubjectId(Long groupSubjectId);

  List<Grade> findAll();

}