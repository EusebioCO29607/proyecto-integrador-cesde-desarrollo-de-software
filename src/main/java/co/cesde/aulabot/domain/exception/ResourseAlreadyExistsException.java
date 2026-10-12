package co.cesde.aulabot.domain.exception;

public class ResourseAlreadyExistsException extends RuntimeException {
  public ResourseAlreadyExistsException(String message) {
    super(message);
  }
}
