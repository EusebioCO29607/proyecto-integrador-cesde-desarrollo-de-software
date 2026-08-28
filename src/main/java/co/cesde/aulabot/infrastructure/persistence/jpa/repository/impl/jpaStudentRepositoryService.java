package co.cesde.aulabot.infrastructure.persistence.jpa.repository.impl;

import co.cesde.aulabot.domain.models.Student;
import co.cesde.aulabot.domain.repository.StudentRepository;
import co.cesde.aulabot.infrastructure.persistence.jpa.repository.JpaStudentRepository;


import java.util.List;
import java.util.Optional;

@Service
public class jpaStudentRepositoryService implements StudentRepository {

    private final JpaStudentRepository jpaStudentRepository;

    public jpaStudentRepositoryService(JpaStudentRepository jpaStudentRepository) {
        this.jpaStudentRepository = jpaStudentRepository;
    }

    @Override
    public Student save(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        if (student.getStudentId() != null && existsByStudentId(student.getStudentId())) {
            throw new IllegalArgumentException("Student with id " + student.getStudentId() + " already exists");
        }
        return jpaStudentRepository.save(student);
    }

    @Override
    public Optional<Student> findByStudentId(Long studentId) {
        return jpaStudentRepository.findByStudentId(studentId);
    }

    @Override
    public List<Student> findAll() {
        return jpaStudentRepository.findAll();
    }

    @Override
    public boolean existsByStudentId(Long studentId) {
        if (studentId == null) return false;
        return jpaStudentRepository.existsByStudentId(studentId);
    }

    @Override
    public void delete(Long studentId) {
        if (!existsByStudentId(studentId)) {
            throw new IllegalArgumentException("Student with id " + studentId + " does not exist");
        }
        jpaStudentRepository.deleteById(studentId);
    }

    @Override
    public Optional<Student> update(Student student) {
        if (student == null || student.getStudentId() == null) {
            throw new IllegalArgumentException("Student or Student ID cannot be null for update");
        }
        if (!existsByStudentId(student.getStudentId())) {
            return Optional.empty();
        }
        return Optional.of(jpaStudentRepository.save(student));
    }


    public Optional<Student> findByCode(String code) {
        return jpaStudentRepository.findByCode(code);
    }

    public Optional<Student> findByDocumentNumber(String documentNumber) {
        return jpaStudentRepository.findByDocumentNumber(documentNumber);
    }

    public Optional<Student> findByUserId(Long userId) {
        return jpaStudentRepository.findByUserId(userId);
    }

    public List<Student> findByFirstName(String firstName) {
        return jpaStudentRepository.findByFirstName(firstName);
    }

    public List<Student> findByLastName(String lastName) {
        return jpaStudentRepository.findByLastName(lastName);
    }

    public List<Student> findByStatus(String status) {
        return jpaStudentRepository.findByStatus(status);
    }

    public List<Student> findByBirthDate(String birthDate) {
        return jpaStudentRepository.findByBirthDate(birthDate);
    }

    public boolean existsByCode(String code) {
        return jpaStudentRepository.existsByCode(code);
    }

    public boolean existsByDocumentNumber(String documentNumber) {
        return jpaStudentRepository.existsByDocumentNumber(documentNumber);
    }

    public boolean existsByUserId(Long userId) {
        return jpaStudentRepository.existsByUserId(userId);
    }
}