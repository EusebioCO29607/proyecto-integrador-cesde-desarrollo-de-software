package co.cesde.aulabot.application.Exceptions;

public class GroupNotFoundException extends RuntimeException {
    public GroupNotFoundException(String message) {
        super(message);
    }

    public GroupNotFoundException(Long id) {
        super("Group with id " + id + " not found");
    }
}
