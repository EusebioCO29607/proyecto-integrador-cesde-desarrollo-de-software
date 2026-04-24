package co.cesde.edu.notapp.ga.repository;

import co.cesde.edu.notapp.ga.models.Enrollment;

import java.util.List;

public interface EnrollmentRepository {

  Enrollment create(Enrollment enrollment);

  boolean delete(Long enrollmentId);

  boolean update(Enrollment enrollmentUpdate);

  Enrollment findById(Long enrollmentId);

  List<Enrollment> findByStudentId(Long studentId);

  List<Enrollment> findByGroupId(Long groupId);

  List<Enrollment> findByPeriodId(Long periodId);

  List<Enrollment> findByStudentIdAndPeriodId(Long studentId, Long periodId);

  List<Enrollment> findAll();

  boolean existsByStudentIdAndGroupId(Long studentId, Long groupId);

}
