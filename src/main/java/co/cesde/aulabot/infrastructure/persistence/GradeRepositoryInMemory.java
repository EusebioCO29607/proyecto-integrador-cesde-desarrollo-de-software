package co.cesde.aulabot.infrastructure.persistence;
import co.cesde.aulabot.domain.models.Grade;
import co.cesde.aulabot.domain.repository.GradeRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GradeRepositoryInMemory implements GradeRepository {


        private final List<Grade> grades = new ArrayList<>();
        @Override
        public Grade create(Grade grade) {
            grades.add(grade);
            return grade;
        }

        @Override
        public boolean delete(Long gradeId) {
            return grades.removeIf(g -> Objects.equals(g.getGradeId(), gradeId));
        }

        @Override
        public boolean update(Grade gradeUpdate) {
            for (int i = 0; i < grades.size(); i++) {
                if (Objects.equals(grades.get(i).getGradeId(), gradeUpdate.getGradeId())) {
                    grades.set(i, gradeUpdate);
                    return true;
                }
            }
            return false;
        }

        @Override
        public Grade findById(Long gradeId) {
            return grades.stream()
                    .filter(g -> Objects.equals(g.getGradeId(), gradeId))
                    .findFirst()
                    .orElse(null);
        }

        @Override
        public List<Grade> findByGroupSubjectId(Long groupSubjectId) {
            return grades.stream()
                    .filter(g -> Objects.equals(g.getGroupSubjectId(), groupSubjectId))
                    .collect(Collectors.toList());
        }

        @Override
        public List<Grade> findByStudentId(Long studentId) {
            return grades.stream()
                    .filter(g -> Objects.equals(g.getStudentId(), studentId))
                    .collect(Collectors.toList());
        }

        @Override
        public List<Grade> findAll() {
            return new ArrayList<>(grades);
        }

        @Override
        public boolean existsByGroupSubjectIdAndStudentId(Long groupSubjectId, Long studentId) {
            return grades.stream()
                    .anyMatch(g -> Objects.equals(g.getGroupSubjectId(), groupSubjectId)
                            && Objects.equals(g.getStudentId(), studentId));
        }
    }
