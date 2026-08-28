package co.cesde.aulabot.infrastructure.persistence.jpa.repository;

import co.cesde.aulabot.domain.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaStudentRepository extends JpaRepository<Student, Long> {

  Student save(Student student);

  Optional<Student> findByStudentId(Long studentId);

  List<Student> findAll();

}
