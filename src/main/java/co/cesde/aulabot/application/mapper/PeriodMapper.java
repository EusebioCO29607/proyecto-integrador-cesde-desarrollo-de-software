package co.cesde.aulabot.application.mapper;
import co.cesde.aulabot.application.dto.PeriodRequest;
import co.cesde.aulabot.domain.models.Period;

public class PeriodMapper {

    public Period toEntity(PeriodRequest request) {
        if (request == null) {
            return null;
        }

        Period period = new Period();
        period.setCode(request.getCode());
        period.setStartDate(request.getStartDate());
        period.setEndDate(request.getEndDate());

        return period;
    }

    public PeriodRequest toDto(Period entity) {
        if (entity == null) {
            return null;
        }

        PeriodRequest request = new PeriodRequest();
        request.setCode(entity.getCode());
        request.setStartDate(entity.getStartDate());
        request.setEndDate(entity.getEndDate());

        return request;
    }
}
