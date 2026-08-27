package co.cesde.aulabot.application.Exceptions;

public class GradeNotFoundException extends RuntimeException {
    public GradeNotFoundException(String message) {
        super(message);
    }

    public GradeNotFoundException(Long id) {
        super("Grade with id " + id + " not found");
    }
}