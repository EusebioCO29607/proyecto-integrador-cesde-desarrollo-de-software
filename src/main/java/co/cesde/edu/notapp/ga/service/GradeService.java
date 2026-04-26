package co.cesde.edu.notapp.ga.service;
import co.cesde.edu.notapp.ga.models.Grade;
import java.util.List;


public interface GradeService {

            Grade create(Grade grade);

            boolean update(Grade gradeUpdate);

            boolean delete(Long gradeId);

            Grade findById(Long gradeId);

            List<Grade> findByStudentId(Long studentId);

            List<Grade> findByGroupSubjectId(Long groupSubjectId);

            List<Grade> findAll();

}
