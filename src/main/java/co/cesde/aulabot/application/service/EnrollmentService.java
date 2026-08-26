package co.cesde.aulabot.application.service;

import co.cesde.aulabot.domain.models.Enrollment;

import java.util.List;

public interface EnrollmentService {

  Enrollment create(Enrollment enrollment);

  boolean update(Enrollment enrollmentUpdate);

  boolean delete(Long enrollmentId);

  List<Enrollment> findByStudentId(Long studentId);

  List<Enrollment> findByGroupId(Long groupId);

  List<Enrollment> findByPeriodId(Long periodId);

  List<Enrollment> findByStudentIdAndPeriodId(Long studentId, Long periodId);

  List<Enrollment> findAll();

}
