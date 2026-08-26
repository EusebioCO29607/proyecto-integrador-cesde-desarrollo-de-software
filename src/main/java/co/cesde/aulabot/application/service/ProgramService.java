package co.cesde.aulabot.application.service;

import co.cesde.aulabot.domain.models.Program;

import java.util.List;

public interface ProgramService {

  Program create(Program program);

  boolean update(Program programUpdate);

  boolean delete(Long programId);

  Program findByCode(String code);

  Program findByName(String name);

  List<Program> findAll();

}
