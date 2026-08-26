package co.cesde.aulabot.application.Exceptions;

public class TeacherNotFoundException extends RuntimeException {
  public TeacherNotFoundException(String message) {
    super(message);
  }
  public TeacherNotFoundException(Long id) {
    super("Student with id " + id + " not found");
  }
}
