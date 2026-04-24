package co.cesde.edu.notapp.ga.service;

import co.cesde.edu.notapp.ga.models.Subject;

import java.util.List;

public interface SubjectService {

  Subject create(Subject subject);

  boolean update(Subject subjectUpdate);

  boolean delete(Long subjectId);

  Subject findByCode(String code);

  List<Subject> findAll();

  List<Subject> findByProgramId(Long programId);

}
