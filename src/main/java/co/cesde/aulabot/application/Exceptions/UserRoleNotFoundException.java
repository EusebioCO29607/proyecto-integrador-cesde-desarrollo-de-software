package co.cesde.aulabot.application.Exceptions;


public class UserRoleNotFoundException extends RuntimeException {
    public UserRoleNotFoundException(String message) {
        super(message);
    }

    public UserRoleNotFoundException(Long id) {
        super("UserRole relation with id " + id + " not found");
    }
}
