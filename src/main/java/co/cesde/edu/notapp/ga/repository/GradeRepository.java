package co.cesde.edu.notapp.ga.repository;
import co.cesde.edu.notapp.ga.models.Grade;
import java.util.List;
public interface GradeRepository {

        Grade create(Grade grade);

        boolean delete(Long gradeId);

        boolean update(Grade gradeUpdate);

        Grade findById(Long gradeId);

        List<Grade> findByGroupSubjectId(Long groupSubjectId);

        List<Grade> findByStudentId(Long studentId);

        List<Grade> findAll();

        boolean existsByGroupSubjectIdAndStudentId(Long groupSubjectId, Long studentId);


}
