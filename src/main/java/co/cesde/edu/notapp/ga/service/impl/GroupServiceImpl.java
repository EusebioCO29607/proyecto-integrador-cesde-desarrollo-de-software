package co.cesde.edu.notapp.ga.service.impl;
import co.cesde.edu.notapp.ga.models.Group;
import co.cesde.edu.notapp.ga.repository.GroupRepository;
import co.cesde.edu.notapp.ga.service.GroupService;

import java.util.List;
        public class GroupServiceImpl implements GroupService {

        private final GroupRepository groupRepository;

        public GroupServiceImpl(GroupRepository groupRepository) {
            this.groupRepository = groupRepository;
        }

        @Override
        public Group create(Group group) {
            if (group == null || isInvalidGroup(group)) {
                return null;
            }

            if (groupRepository.existsByCode(group.getCode())) {
                return null;
            }
            return groupRepository.create(group);
        }

        @Override
        public boolean update(Group groupUpdate) {
            if (groupUpdate == null || groupUpdate.getGroupId() == null || isInvalidGroup(groupUpdate)) {
                return false;
            }

            Group existing = groupRepository.findById(groupUpdate.getGroupId());
            if (existing == null) {
                return false;
            }

            if (!existing.getCode().equals(groupUpdate.getCode()) &&
                    groupRepository.existsByCode(groupUpdate.getCode())) {
                return false;
            }

            return groupRepository.update(groupUpdate);
        }

        @Override
        public boolean delete(Long groupId) {
            if (groupId == null || groupId < 1L) {
                return false;
            }
            Group existing = groupRepository.findById(groupId);
            if (existing == null) {
                return false;
            }
            return groupRepository.delete(groupId);
        }

        @Override
        public Group findById(Long groupId) {
            if (groupId == null || groupId < 1L) {
                return null;
            }
            return groupRepository.findById(groupId);
        }

        @Override
        public List<Group> findByProgramId(Long programId) {
            if (programId == null || programId < 1L) {
                return List.of();
            }
            return groupRepository.findByProgramId(programId);
        }

        @Override
        public List<Group> findByPeriodId(Long periodId) {
            if (periodId == null || periodId < 1L) {
                return List.of();
            }
            return groupRepository.findByPeriodId(periodId);
        }

        @Override
        public List<Group> findAll() {
            return groupRepository.findAll();
        }

        private boolean isInvalidGroup(Group group) {
            return !isNotBlank(group.getCode())
                    || group.getProgramId() == null || group.getProgramId() < 1L
                    || group.getPeriodId() == null || group.getPeriodId() < 1L
                    || !isNotBlank(group.getShift());
        }

        private boolean isNotBlank(String value) {
            return value != null && !value.isBlank();
        }

}
