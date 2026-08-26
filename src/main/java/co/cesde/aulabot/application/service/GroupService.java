package co.cesde.aulabot.application.service;
import co.cesde.aulabot.domain.models.Group;
import java.util.List;
public interface GroupService {


        Group create(Group group);

        boolean update(Group groupUpdate);

        boolean delete(Long groupId);

        Group findById(Long groupId);

        List<Group> findByProgramId(Long programId);

        List<Group> findByPeriodId(Long periodId);

        List<Group> findAll();

}
