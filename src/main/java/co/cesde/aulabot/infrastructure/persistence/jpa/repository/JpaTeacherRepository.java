package co.cesde.aulabot.infrastructure.persistence.jpa.repository;

import co.cesde.aulabot.domain.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaTeacherRepository extends JpaRepository<Teacher, Long> {

  Teacher save(Teacher teacher);

  Optional<Teacher> findByDocumentNumber(String documentNumber);

  boolean existsByDocumentNumber(String documentNumber);

  List<Teacher> findAll();

}