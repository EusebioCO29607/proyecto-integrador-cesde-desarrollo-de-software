package co.cesde.aulabot.application.mapper;


import co.cesde.aulabot.application.dto.ProgramRequest;
import co.cesde.aulabot.domain.models.Program;

public class ProgramMapper {

    public Program toEntity(ProgramRequest request) {
        if (request == null) {
            return null;
        }

        Program program = new Program();
        program.setName(request.getName());
        program.setCode(request.getCode());

        return program;
    }

    public ProgramRequest toDto(Program entity) {
        if (entity == null) {
            return null;
        }

        ProgramRequest request = new ProgramRequest();
        request.setName(entity.getName());
        request.setCode(entity.getCode());

        return request;
    }
}
