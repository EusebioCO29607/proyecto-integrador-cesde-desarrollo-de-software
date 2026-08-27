package co.cesde.aulabot.application.Exceptions;

public class PeriodNotFoundException extends RuntimeException {
    public PeriodNotFoundException(String message) {
        super(message);
    }

    public PeriodNotFoundException(Long id) {
        super("Period with id " + id + " not found");
    }
}
