package co.cesde.aulabot.infrastructure.persistence.jpa.repository.impl;

import co.cesde.aulabot.domain.models.Period;
import co.cesde.aulabot.domain.repository.PeriodRepository;
import co.cesde.aulabot.infrastructure.persistence.jpa.repository.JpaPeriodRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public abstract class PeriodRepositoryService implements PeriodRepository {

  private final JpaPeriodRepository jpaPeriodRepository;

  public PeriodRepositoryService(JpaPeriodRepository jpaPeriodRepository) {
    this.jpaPeriodRepository = jpaPeriodRepository;
  }

  @Override
  public Period create(Period period) {
    if (period == null) {
      throw new IllegalArgumentException("Period cannot be null");
    }
    if (existsByCode(period.getCode())) {
      throw new IllegalArgumentException("Period with code " + period.getCode() + " already exists");
    }
    return jpaPeriodRepository.save(period);
  }

  @Override
  public boolean delete(Long periodId) {
    if (periodId == null || jpaPeriodRepository.findById(periodId).isEmpty()) {
      return false;
    }
    jpaPeriodRepository.deleteById(periodId);
    return true;
  }

  @Override
  public boolean update(Period periodUpdate) {
    if (periodUpdate == null || periodUpdate.getPeriodId() == null) {
      return false;
    }
    if (jpaPeriodRepository.findById(periodUpdate.getPeriodId()).isEmpty()) {
      return false;
    }
    jpaPeriodRepository.save(periodUpdate);
    return true;
  }

  @Override
  public Period findById(Long periodId) {
    return jpaPeriodRepository.findById(periodId).orElse(null);
  }

  @Override
  public List<Period> findAll() {
    return jpaPeriodRepository.findAll();
  }

  @Override
  public boolean existsByCode(String code) {
    return jpaPeriodRepository.existsByCode(code);
  }
}