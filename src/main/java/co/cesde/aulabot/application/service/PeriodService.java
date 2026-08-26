package co.cesde.aulabot.application.service;
import co.cesde.aulabot.domain.models.Period;
import java.util.List;
public interface PeriodService {

        Period create(Period period);

        boolean update(Period periodUpdate);

        boolean delete(Long periodId);

        Period findById(Long periodId);

        Period findByCode(String code);

        List<Period> findAll();


}
