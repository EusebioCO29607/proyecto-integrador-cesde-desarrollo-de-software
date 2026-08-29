package co.cesde.aulabot.infrastructure.persistence.jpa.repository.impl;

import co.cesde.aulabot.domain.models.Program;
import co.cesde.aulabot.domain.repository.ProgramRepository;
import co.cesde.aulabot.infrastructure.persistence.jpa.repository.JpaProgramRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public abstract class ProgramRepositoryService implements ProgramRepository {

  private final JpaProgramRepository jpaProgramRepository;

  public ProgramRepositoryService(JpaProgramRepository jpaProgramRepository) {
    this.jpaProgramRepository = jpaProgramRepository;
  }

  @Override
  public Program create(Program program) {
    if (program == null) {
      throw new IllegalArgumentException("Program cannot be null");
    }
    if (existsByCode(program.getCode())) {
      throw new IllegalArgumentException("Program with code " + program.getCode() + " already exists");
    }
    return jpaProgramRepository.save(program);
  }

  @Override
  public boolean delete(Long programId) {
    if (programId == null || jpaProgramRepository.findById(programId).isEmpty()) {
      return false;
    }
    jpaProgramRepository.deleteById(programId);
    return true;
  }

  @Override
  public boolean update(Program programUpdate) {
    if (programUpdate == null || programUpdate.getProgramId() == null) {
      return false;
    }
    if (jpaProgramRepository.findById(programUpdate.getProgramId()).isEmpty()) {
      return false;
    }
    jpaProgramRepository.save(programUpdate);
    return true;
  }

  @Override
  public Program findById(Long programId) {
    return jpaProgramRepository.findById(programId).orElse(null);
  }

  @Override
  public List<Program> findAll() {
    return jpaProgramRepository.findAll();
  }

  @Override
  public boolean existsByCode(String code) {
    return jpaProgramRepository.existsByCode(code);
  }
}