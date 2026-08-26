package co.cesde.aulabot.application.service.impl;
import co.cesde.aulabot.domain.models.Grade;
import co.cesde.aulabot.domain.repository.GradeRepository;
import co.cesde.aulabot.application.service.GradeService;

import java.util.List;

    public class GradeServiceImpl implements GradeService {

        private final GradeRepository gradeRepository;

        public GradeServiceImpl(GradeRepository gradeRepository) {
            this.gradeRepository = gradeRepository;
        }

        @Override
        public Grade create(Grade grade) {
            if (grade == null || isInvalidGrade(grade)) {
                return null;
            }

            if (gradeRepository.existsByGroupSubjectIdAndStudentId(
                    grade.getGroupSubjectId(), grade.getStudentId())) {
                return null;
            }
            return gradeRepository.create(grade);
        }

        @Override
        public boolean update(Grade gradeUpdate) {
            if (gradeUpdate == null || gradeUpdate.getGradeId() == null || isInvalidGrade(gradeUpdate)) {
                return false;
            }
            Grade existing = gradeRepository.findById(gradeUpdate.getGradeId());
            if (existing == null) {
                return false;
            }


            boolean relationChanged = !existing.getGroupSubjectId().equals(gradeUpdate.getGroupSubjectId()) ||
                    !existing.getStudentId().equals(gradeUpdate.getStudentId());

            if (relationChanged && gradeRepository.existsByGroupSubjectIdAndStudentId(
                    gradeUpdate.getGroupSubjectId(), gradeUpdate.getStudentId())) {
                return false;
            }

            return gradeRepository.update(gradeUpdate);
        }

        @Override
        public boolean delete(Long gradeId) {
            if (gradeId == null || gradeId < 1L) {
                return false;
            }
            Grade existing = gradeRepository.findById(gradeId);
            if (existing == null) {
                return false;
            }
            return gradeRepository.delete(gradeId);
        }

        @Override
        public Grade findById(Long gradeId) {
            if (gradeId == null || gradeId < 1L) {
                return null;
            }
            return gradeRepository.findById(gradeId);
        }

        @Override
        public List<Grade> findByStudentId(Long studentId) {
            if (studentId == null || studentId < 1L) {
                return List.of();
            }
            return gradeRepository.findByStudentId(studentId);
        }

        @Override
        public List<Grade> findByGroupSubjectId(Long groupSubjectId) {
            if (groupSubjectId == null || groupSubjectId < 1L) {
                return List.of();
            }
            return gradeRepository.findByGroupSubjectId(groupSubjectId);
        }

        @Override
        public List<Grade> findAll() {
            return gradeRepository.findAll();
        }

        private boolean isInvalidGrade(Grade grade) {
            return grade.getGroupSubjectId() == null || grade.getGroupSubjectId() < 1L
                    || grade.getStudentId() == null || grade.getStudentId() < 1L
                    || grade.getFinalScore() == null || grade.getFinalScore() < 0.0 || grade.getFinalScore() > 5.0
                    || !isNotBlank(grade.getObservation());
        }

        private boolean isNotBlank(String value) {
            return value != null && !value.isBlank();
        }

}
