package co.cesde.aulabot.infrastructure.persistence;

import co.cesde.aulabot.domain.models.Period;
import co.cesde.aulabot.domain.repository.PeriodRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PeriodRepositoryInMemory implements PeriodRepository {

    private final List<Period> periods = new ArrayList<>();

    @Override
    public Period create(Period period) {
        periods.add(period);
        return period;
    }

    @Override
    public boolean delete(Long periodId) {
        return periods.removeIf(p -> Objects.equals(p.getPeriodId(), periodId));
    }

    @Override
    public boolean update(Period periodUpdate) {
        for (int i = 0; i < periods.size(); i++) {
            if (Objects.equals(periods.get(i).getPeriodId(), periodUpdate.getPeriodId())) {
                periods.set(i, periodUpdate);
                return true;
            }
        }
        return false;
    }

    @Override
    public Period findById(Long periodId) {
        return periods.stream()
                .filter(p -> Objects.equals(p.getPeriodId(), periodId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Period findByCode(String code) {
        return periods.stream()
                .filter(p -> Objects.equals(p.getCode(), code))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Period> findAll() {
        return new ArrayList<>(periods);
    }

    @Override
    public boolean existsByCode(String code) {
        return periods.stream()
                .anyMatch(p -> Objects.equals(p.getCode(), code));
    }
}