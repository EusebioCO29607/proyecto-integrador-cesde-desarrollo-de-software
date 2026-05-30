package co.cesde.edu.notapp.ga.exceptions;

public class TeacherNotFoundException extends RuntimeException {
  public TeacherNotFoundException(String message) {
    super(message);
  }
  public TeacherNotFoundException(Long id) {
    super("Student with id " + id + " not found");
  }
}
