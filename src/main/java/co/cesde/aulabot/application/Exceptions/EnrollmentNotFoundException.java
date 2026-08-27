package co.cesde.aulabot.application.Exceptions;

public class EnrollmentNotFoundException extends RuntimeException {
    public EnrollmentNotFoundException(String message) {
        super(message);
    }

    public EnrollmentNotFoundException(Long id) {
        super("Enrollment with id " + id + " not found");
    }
}