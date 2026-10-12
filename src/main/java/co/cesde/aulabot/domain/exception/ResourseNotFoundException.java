package co.cesde.aulabot.domain.exception;

public class ResourseNotFoundException extends RuntimeException {
  public ResourseNotFoundException(String message) {
    super(message);
  }
}
