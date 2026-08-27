package co.cesde.aulabot.application.Exceptions;


public class SubjectNotFoundException extends RuntimeException {
    public SubjectNotFoundException(String message) {
        super(message);
    }

    public SubjectNotFoundException(Long id) {
        super("Subject with id " + id + " not found");
    }
}