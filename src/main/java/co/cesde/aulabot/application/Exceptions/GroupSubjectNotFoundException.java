package co.cesde.aulabot.application.Exceptions;



public class GroupSubjectNotFoundException extends RuntimeException {
    public GroupSubjectNotFoundException(String message) {
        super(message);
    }

    public GroupSubjectNotFoundException(Long id) {
        super("GroupSubject relation with id " + id + " not found");
    }
}
