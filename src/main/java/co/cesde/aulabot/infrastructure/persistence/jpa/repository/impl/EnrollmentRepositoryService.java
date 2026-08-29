package co.cesde.aulabot.infrastructure.persistence.jpa.repository.impl;

import co.cesde.aulabot.domain.models.Enrollment;
import co.cesde.aulabot.domain.repository.EnrollmentRepository;
import co.cesde.aulabot.infrastructure.persistence.jpa.repository.JpaEnrollmentRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public abstract class EnrollmentRepositoryService implements EnrollmentRepository {

  private final JpaEnrollmentRepository jpaEnrollmentRepository;

  public EnrollmentRepositoryService(JpaEnrollmentRepository jpaEnrollmentRepository) {
    this.jpaEnrollmentRepository = jpaEnrollmentRepository;
  }

  @Override
  public Enrollment create(Enrollment enrollment) {
    if (enrollment == null) {
      throw new IllegalArgumentException("Enrollment cannot be null");
    }
    return jpaEnrollmentRepository.save(enrollment);
  }

  @Override
  public boolean delete(Long enrollmentId) {
    if (enrollmentId == null || jpaEnrollmentRepository.findById(enrollmentId).isEmpty()) {
      return false;
    }
    jpaEnrollmentRepository.deleteById(enrollmentId);
    return true;
  }

  @Override
  public boolean update(Enrollment enrollmentUpdate) {
    if (enrollmentUpdate == null || enrollmentUpdate.getEnrollmentId() == null) {
      return false;
    }
    if (jpaEnrollmentRepository.findById(enrollmentUpdate.getEnrollmentId()).isEmpty()) {
      return false;
    }
    jpaEnrollmentRepository.save(enrollmentUpdate);
    return true;
  }

  @Override
  public Enrollment findById(Long enrollmentId) {
    return jpaEnrollmentRepository.findById(enrollmentId).orElse(null);
  }

  @Override
  public List<Enrollment> findAll() {
    return jpaEnrollmentRepository.findAll();
  }
}