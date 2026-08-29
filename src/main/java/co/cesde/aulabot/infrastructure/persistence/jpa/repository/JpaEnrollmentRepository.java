package co.cesde.aulabot.infrastructure.persistence.jpa.repository;

import co.cesde.aulabot.domain.models.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaEnrollmentRepository extends JpaRepository<Enrollment, Long> {

  Enrollment save(Enrollment enrollment);

  List<Enrollment> findAll();

}