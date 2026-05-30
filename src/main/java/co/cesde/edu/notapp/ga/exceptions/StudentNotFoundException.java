package co.cesde.edu.notapp.ga.exceptions;

public class StudentNotFoundException extends RuntimeException {
  public StudentNotFoundException(String message) {
    super(message);
  }

  public StudentNotFoundException(Long id) {
    super("Student with id " + id + " not found");
  }

}
