package co.cesde.aulabot.infrastructure.persistence;

import co.cesde.aulabot.domain.models.Group;
import co.cesde.aulabot.domain.repository.GroupRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GroupRepositoryInMemory implements GroupRepository {

    private final List<Group> groups = new ArrayList<>();

    @Override
    public Group create(Group group) {
        groups.add(group);
        return group;
    }

    @Override
    public boolean delete(Long groupId) {
        return groups.removeIf(g -> Objects.equals(g.getGroupId(), groupId));
    }

    @Override
    public boolean update(Group groupUpdate) {
        for (int i = 0; i < groups.size(); i++) {
            if (Objects.equals(groups.get(i).getGroupId(), groupUpdate.getGroupId())) {
                groups.set(i, groupUpdate);
                return true;
            }
        }
        return false;
    }

    @Override
    public Group findById(Long groupId) {
        return groups.stream()
                .filter(g -> Objects.equals(g.getGroupId(), groupId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Group> findByProgramId(Long programId) {
        return groups.stream()
                .filter(g -> Objects.equals(g.getProgramId(), programId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Group> findByPeriodId(Long periodId) {
        return groups.stream()
                .filter(g -> Objects.equals(g.getPeriodId(), periodId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Group> findAll() {
        return new ArrayList<>(groups);
    }

    @Override
    public boolean existsByCode(String code) {
        return groups.stream()
                .anyMatch(g -> Objects.equals(g.getCode(), code));
    }
}