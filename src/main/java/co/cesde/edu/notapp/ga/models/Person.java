package co.cesde.edu.notapp.ga.models;

public abstract class Person {

    protected String firstName;
    protected String lastName;
    protected String userId;
    protected boolean status;

    public Person() {
    }

    public Person(String firstName, String lastName, String userId, boolean status) {
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
        return
    }

