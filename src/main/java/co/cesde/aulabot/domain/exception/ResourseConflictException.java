package co.cesde.aulabot.domain.exception;

public class ResourseConflictException extends RuntimeException {
  public ResourseConflictException(String message) {
    super(message);
  }
}
