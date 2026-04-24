package co.cesde.edu.notapp.ga.service.impl;

import co.cesde.edu.notapp.ga.models.Program;
import co.cesde.edu.notapp.ga.repository.ProgramRepository;
import co.cesde.edu.notapp.ga.service.ProgramService;

import java.util.List;

public class ProgramServiceImpl implements ProgramService {

  private final ProgramRepository programRepository;

  public ProgramServiceImpl(ProgramRepository programRepository) {
    this.programRepository = programRepository;
  }

  @Override
  public Program create(Program program) {
    if (program ==  null || isInvalidProgram(program)) {
      return null;
    }
    if (programRepository.existsByCode(program.getCode())) {
      return null;
    }
    if (programRepository.existsByName(program.getName())) {
      return null;
    }
    return programRepository.create(program);
  }

  @Override
  public boolean update(Program programUpdate) {
    if (programUpdate == null || programUpdate.getProgramId() == null) {
      return false;
    }
    if (isInvalidProgram(programUpdate)) {
      return false;
    }
    Program program = programRepository.findById(programUpdate.getProgramId());
    if (program == null) {
      return false;
    }
    if (!program.getCode().equals(programUpdate.getCode())
        && programRepository.existsByCode(programUpdate.getCode())) {
      return false;
    }
    if (!program.getName().equalsIgnoreCase(programUpdate.getName())
        && programRepository.existsByName(programUpdate.getName())) {
      return false;
    }
    return programRepository.update(programUpdate);
  }

  @Override
  public boolean delete(Long programId) {
    if (programId == null) {
      return false;
    }
    Program existing = programRepository.findById(programId);
    if (existing == null) {
      return false;
    }
    return programRepository.delete(programId);
  }

  @Override
  public Program findByCode(String code) {
    if (code == null || code.isBlank()) {
      return null;
    }
    return programRepository.findByCode(code);
  }

  @Override
  public Program findByName(String name) {
    if (name == null || name.isBlank()) {
      return null;
    }
    return programRepository.findByName(name);
  }

  @Override
  public List<Program> findAll() {
    return programRepository.findAll();
  }

  private boolean isInvalidProgram(Program program) {
    return !isNotBlank(program.getName())
        || !isNotBlank(program.getCode());
  }

  private boolean isNotBlank(String value) {
    return value != null && !value.isBlank();
  }

}
