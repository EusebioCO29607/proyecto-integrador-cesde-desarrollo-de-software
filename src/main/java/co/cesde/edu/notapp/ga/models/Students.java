package co.cesde.edu.notapp.ga.models;

public class Students extends Person {

    private String firstName;
    private String lastName;
    private String userId;
    private boolean status;

    public Students() {
    }

    public Students(String firstName, String lastName, String userId, boolean status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserId() {
        return userId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String getRole() {
        return "Student";
    }
}
