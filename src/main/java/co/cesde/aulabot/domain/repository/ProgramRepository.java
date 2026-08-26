package co.cesde.aulabot.domain.repository;

import co.cesde.aulabot.domain.models.Program;

import java.util.List;

public interface ProgramRepository {

  Program create(Program program);

  boolean delete(Long programId);

  boolean update(Program programUpdate);

  Program findById(Long programId);

  Program findByCode(String code);

  Program findByName(String name);

  List<Program> findAll();

  boolean existsByCode(String code);

  boolean existsByName(String name);

}
