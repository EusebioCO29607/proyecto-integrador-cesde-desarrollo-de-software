package co.cesde.aulabot.application.service.impl;
import co.cesde.aulabot.domain.models.Period;
import co.cesde.aulabot.domain.repository.PeriodRepository;
import co.cesde.aulabot.application.service.PeriodService;

import java.util.List;


        public class PeriodServiceImpl implements PeriodService {

        private final PeriodRepository periodRepository;

        public PeriodServiceImpl(PeriodRepository periodRepository) {
            this.periodRepository = periodRepository;
        }

        @Override
        public Period create(Period period) {
            if (period == null || isInvalidPeriod(period)) {
                return null;
            }
            if (periodRepository.existsByCode(period.getCode())) {
                return null;
            }
            return periodRepository.create(period);
        }

        @Override
        public boolean update(Period periodUpdate) {
            if (periodUpdate == null || periodUpdate.getPeriodId() == null || isInvalidPeriod(periodUpdate)) {
                return false;
            }
            Period existing = periodRepository.findById(periodUpdate.getPeriodId());
            if (existing == null) {
                return false;
            }


            if (!existing.getCode().equals(periodUpdate.getCode()) &&
                    periodRepository.existsByCode(periodUpdate.getCode())) {
                return false;
            }

            return periodRepository.update(periodUpdate);
        }

        @Override
        public boolean delete(Long periodId) {
            if (periodId == null || periodId < 1L) {
                return false;
            }
            Period existing = periodRepository.findById(periodId);
            if (existing == null) {
                return false;
            }
            return periodRepository.delete(periodId);
        }

        @Override
        public Period findById(Long periodId) {
            if (periodId == null || periodId < 1L) {
                return null;
            }
            return periodRepository.findById(periodId);
        }

        @Override
        public Period findByCode(String code) {
            if (!isNotBlank(code)) {
                return null;
            }
            return periodRepository.findByCode(code);
        }

        @Override
        public List<Period> findAll() {
            return periodRepository.findAll();
        }

        private boolean isInvalidPeriod(Period period) {
            return !isNotBlank(period.getCode())
                    || !isNotBlank(period.getStartDate())
                    || !isNotBlank(period.getEndDate());
        }

        private boolean isNotBlank(String value) {
            return value != null && !value.isBlank();
        }

}
