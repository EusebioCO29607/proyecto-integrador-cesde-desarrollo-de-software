package co.cesde.aulabot.infrastructure.persistence.jpa.repository;

import co.cesde.aulabot.domain.models.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaProgramRepository extends JpaRepository<Program, Long> {

  Program save(Program program);

  boolean existsByCode(String code);

  List<Program> findAll();

}