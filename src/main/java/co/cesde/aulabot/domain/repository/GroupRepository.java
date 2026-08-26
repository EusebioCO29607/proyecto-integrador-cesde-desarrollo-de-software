package co.cesde.aulabot.domain.repository;

import co.cesde.aulabot.domain.models.Group;
import java.util.List;

public interface GroupRepository {


        Group create(Group group);

        boolean delete(Long groupId);

        boolean update(Group groupUpdate);

        Group findById(Long groupId);

        List<Group> findByProgramId(Long programId);

        List<Group> findByPeriodId(Long periodId);

        List<Group> findAll();

        boolean existsByCode(String code);

    }

