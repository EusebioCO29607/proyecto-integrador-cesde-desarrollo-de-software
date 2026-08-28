package co.cesde.aulabot.infrastructure.persistence.jpa.repository;

import co.cesde.aulabot.domain.models.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaStudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByStudentId(Long studentId);
    Optional<Student> findByCode(String code);
    Optional<Student> findByDocumentNumber(String documentNumber);
    Optional<Student> findByUserId(Long userId);


    List<Student> findByFirstName(String firstName);
    List<Student> findByLastName(String lastName);
    List<Student> findByStatus(String status);
    List<Student> findByBirthDate(String birthDate);

    boolean existsByStudentId(Long studentId);
    boolean existsByCode(String code);
    boolean existsByDocumentNumber(String documentNumber);
    boolean existsByUserId(Long userId);
}