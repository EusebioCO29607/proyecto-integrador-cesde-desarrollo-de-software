package co.cesde.aulabot.application.Exceptions;

public class ProgramNotFoundException extends RuntimeException {
    public ProgramNotFoundException(String message) {
        super(message);
    }

    public ProgramNotFoundException(Long id) {
        super("Program with id " + id + " not found");
    }
}