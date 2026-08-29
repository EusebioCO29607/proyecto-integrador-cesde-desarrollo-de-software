package co.cesde.aulabot.infrastructure.persistence.jpa.repository;

import co.cesde.aulabot.domain.models.Period;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaPeriodRepository extends JpaRepository<Period, Long> {

  Period save(Period period);

  boolean existsByCode(String code);

  List<Period> findAll();

}