package co.cesde.aulabot.application.service.impl;

import co.cesde.aulabot.domain.models.Enrollment;
import co.cesde.aulabot.domain.repository.EnrollmentRepository;
import co.cesde.aulabot.application.service.EnrollmentService;

import java.util.List;

public class EnrollmentServiceImpl implements EnrollmentService {

  private final EnrollmentRepository enrollmentRepository;

  public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository) {
    this.enrollmentRepository = enrollmentRepository;
  }

  @Override
  public Enrollment create(Enrollment enrollment) {
    if (enrollment == null || isInvalidEnrollment(enrollment)) {
      return null;
    }
    if (enrollmentRepository.existsByStudentIdAndGroupId(
        enrollment.getStudentId(), enrollment.getGroupId())) {
      return null;
    }
    return enrollmentRepository.create(enrollment);
  }

  @Override
  public boolean update(Enrollment enrollmentUpdate) {
    if (enrollmentUpdate == null || enrollmentUpdate.getEnrollmentId() == null) {
      return false;
    }
    if (isInvalidEnrollment(enrollmentUpdate)) {
      return false;
    }
    Enrollment existing = enrollmentRepository.findById(enrollmentUpdate.getEnrollmentId());
    if (existing == null) {
      return false;
    }
    boolean studentOrGroupChanged =
        !existing.getStudentId().equals(enrollmentUpdate.getStudentId()) ||
            !existing.getGroupId().equals(enrollmentUpdate.getGroupId());

    if (studentOrGroupChanged && enrollmentRepository.existsByStudentIdAndGroupId(
        enrollmentUpdate.getStudentId(), enrollmentUpdate.getGroupId())) {
      return false;
    }
    return enrollmentRepository.update(enrollmentUpdate);
  }

  @Override
  public boolean delete(Long enrollmentId) {
    if (enrollmentId == null) {
      return false;
    }
    Enrollment existing = enrollmentRepository.findById(enrollmentId);
    if (existing == null) {
      return false;
    }
    return enrollmentRepository.delete(enrollmentId);
  }

  @Override
  public List<Enrollment> findByStudentId(Long studentId) {
    if (studentId == null || studentId < 1L) {
      return List.of();
    }
    return enrollmentRepository.findByStudentId(studentId);
  }

  @Override
  public List<Enrollment> findByGroupId(Long groupId) {
    if (groupId == null || groupId < 1L) {
      return List.of();
    }
    return enrollmentRepository.findByGroupId(groupId);
  }

  @Override
  public List<Enrollment> findByPeriodId(Long periodId) {
    if (periodId == null || periodId < 1L) {
      return List.of();
    }
    return enrollmentRepository.findByPeriodId(periodId);
  }

  @Override
  public List<Enrollment> findAll() {
    return enrollmentRepository.findAll();
  }

  @Override
  public List<Enrollment> findByStudentIdAndPeriodId(Long studentId, Long periodId) {
    if (studentId == null || studentId < 0L || periodId == null || periodId < 0L) {
      return List.of();
    }
    return enrollmentRepository.findByStudentIdAndPeriodId(studentId, periodId);
  }

  private boolean isInvalidEnrollment(Enrollment enrollment) {
    return enrollment.getStudentId() == null || enrollment.getStudentId() < 1L
        || enrollment.getGroupId() == null || enrollment.getGroupId() < 1L
        || enrollment.getPeriodId() == null || enrollment.getPeriodId() < 1L
        || !isNotBlank(enrollment.getStatus())
        || !isNotBlank(enrollment.getEnrolledAt());
  }

  private boolean isNotBlank(String value) {
    return value != null && !value.isBlank();
  }
}
