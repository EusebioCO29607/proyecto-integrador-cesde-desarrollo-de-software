package co.cesde.aulabot.infrastructure.persistence;

import co.cesde.aulabot.domain.models.Program;
import co.cesde.aulabot.domain.repository.ProgramRepository;

import java.util.ArrayList;
import java.util.List;

public class ProgramRepositoryInMemory implements ProgramRepository {

  private List<Program> programs;
  private Long nextProgramId;

  public ProgramRepositoryInMemory() {
    this.programs = new ArrayList<>();
    this.nextProgramId = 1L;
  }

  @Override
  public Program create(Program program) {
    if (program == null) {
      return null;
    }
    program.setProgramId(nextProgramId++);
    programs.add(program);
    return program;
  }

  @Override
  public boolean delete(Long programId) {
    if (programId == null) {
      return false;
    }
    Program program = findById(programId);
    if (program == null) {
      return false;
    }
    return programs.remove(program);
  }

  @Override
  public boolean update(Program programUpdate) {
    if (programUpdate == null || programUpdate.getProgramId() == null) {
      return false;
    }
    for (int i=0; i < programs.size(); i++) {
      if (programs.get(i).getProgramId().equals(programUpdate.getProgramId())) {
        programs.set(i, programUpdate);
        return true;
      }
    }
    return false;
  }

  @Override
  public Program findById(Long programId) {
    if (programId == null || programId < 0L) {
      return null;
    }
    for (Program program : programs) {
      if (program.getProgramId().equals(programId)) {
        return program;
      }
    }
    return null;
  }

  @Override
  public Program findByCode(String code) {
    if (code == null || code.isBlank()) {
      return null;
    }
    for (Program program : programs) {
      if (program.getCode().equals(code)) {
        return program;
      }
    }
    return null;
  }

  @Override
  public Program findByName(String name) {
    if (name == null || name.isBlank()) {
      return null;
    }
    for (Program program : programs) {
      if (program.getName().equalsIgnoreCase(name)) {
        return program;
      }
    }
    return null;
  }

  @Override
  public boolean existsByCode(String code) {
    return findByCode(code) != null;
  }

  @Override
  public boolean existsByName(String name) {
    return findByName(name) != null;
  }

  @Override
  public List<Program> findAll() {
    return List.of(programs.toArray(new Program[0]));
  }

}
