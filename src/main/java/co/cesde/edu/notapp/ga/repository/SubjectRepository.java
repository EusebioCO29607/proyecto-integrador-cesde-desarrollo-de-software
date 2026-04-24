package co.cesde.edu.notapp.ga.repository;

import co.cesde.edu.notapp.ga.models.Subject;

import java.util.List;

public interface SubjectRepository {
  Subject create(Subject subject) ;

  boolean delete(Long subjectId);

  List<Subject> findAll();

  List<Subject> findByProgramId(Long programId);

  Subject findById(Long subjectId);

  boolean update(Subject subjectUpdate);

  Subject findByCode (String code);

  boolean existsByCode(String code);

}
