package co.cesde.aulabot.domain.repository.impl;

import co.cesde.aulabot.domain.models.Enrollment;
import co.cesde.aulabot.domain.repository.EnrollmentRepository;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepositoryInMemory implements EnrollmentRepository {

  private List<Enrollment> enrollments;
  private Long nextEnrollmentId;

  public EnrollmentRepositoryInMemory() {
    this.enrollments = new ArrayList<>();
    this.nextEnrollmentId = 1L;
  }

  @Override
  public Enrollment create(Enrollment enrollment) {
    if (enrollment == null) {
      return null;
    }
    enrollment.setEnrollmentId(nextEnrollmentId++);
    enrollments.add(enrollment);
    return enrollment;
  }

  @Override
  public boolean delete(Long enrollmentId) {
    if (enrollmentId == null) {
      return false;
    }
    Enrollment enrollment = findById(enrollmentId);
    if (enrollment == null) {
      return false;
    }
    return enrollments.remove(enrollment);
  }

  @Override
  public boolean update(Enrollment enrollmentUpdate) {
    if (enrollmentUpdate == null || enrollmentUpdate.getEnrollmentId() == null) {
      return false;
    }
    for (int i = 0; i < enrollments.size(); i++) {
      if (enrollments.get(i).getEnrollmentId().equals(enrollmentUpdate.getEnrollmentId())) {
        enrollments.set(i, enrollmentUpdate);
        return true;
      }
    }
    return false;
  }

  @Override
  public Enrollment findById(Long enrollmentId) {
    if (enrollmentId == null || enrollmentId < 0L) {
      return null;
    }
    for (Enrollment enrollment : enrollments) {
      if (enrollment.getEnrollmentId().equals(enrollmentId)) {
        return enrollment;
      }
    }
    return null;
  }

  @Override
  public List<Enrollment> findByStudentId(Long studentId) {
    if (studentId == null || studentId < 0L) {
      return new ArrayList<>();
    }
    List<Enrollment> enrollments = new ArrayList<>();
    for (Enrollment enrollment : enrollments) {
      if (enrollment.getStudentId().equals(studentId)) {
        enrollments.add(enrollment);
      }
    }
    return enrollments;
  }

  @Override
  public List<Enrollment> findByGroupId(Long groupId) {
    if (groupId == null || groupId < 0L) {
      return new ArrayList<>();
    }
    List<Enrollment> enrollments = new ArrayList<>();
    for (Enrollment enrollment : enrollments) {
      if (enrollment.getGroupId().equals(groupId)) {
        enrollments.add(enrollment);
      }
    }
    return enrollments;
  }

  @Override
  public List<Enrollment> findByPeriodId(Long periodId) {
    if (periodId == null || periodId < 0L) {
      return new ArrayList<>();
    }
    List<Enrollment> enrollments = new ArrayList<>();
    for (Enrollment enrollment : enrollments) {
      if (enrollment.getPeriodId().equals(periodId)) {
        enrollments.add(enrollment);
      }
    }
    return enrollments;
  }

  @Override
  public List<Enrollment> findByStudentIdAndPeriodId(Long studentId, Long periodId) {
    if (studentId == null || studentId < 0L || periodId == null || periodId < 0L) {
      return new ArrayList<>();
    }
    List<Enrollment> enrollments = new ArrayList<>();
    for (Enrollment enrollment : enrollments) {
      if (enrollment.getStudentId().equals(studentId) &&
      enrollment.getPeriodId().equals(periodId)) {
        enrollments.add(enrollment);
      }
    }
    return enrollments;
  }

  @Override
  public List<Enrollment> findAll() {
    return List.of(enrollments.toArray(new Enrollment[0]));
  }

  @Override
  public boolean existsByStudentIdAndGroupId(Long studentId, Long groupId) {
    if (studentId == null || groupId == null) {
      return false;
    }
    for (Enrollment enrollment : enrollments) {
      if (enrollment.getStudentId().equals(studentId) && enrollment.getGroupId().equals(groupId)) {
        return true;
      }
    }
    return false;
  }
}
