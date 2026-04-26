package co.cesde.edu.notapp.ga.repository;
import co.cesde.edu.notapp.ga.models.Period;
import java.util.List;
public interface PeriodRepository {


        Period create(Period period);

        boolean delete(Long periodId);

        boolean update(Period periodUpdate);

        Period findById(Long periodId);

        Period findByCode(String code);

        List<Period> findAll();

        boolean existsByCode(String code);


}
