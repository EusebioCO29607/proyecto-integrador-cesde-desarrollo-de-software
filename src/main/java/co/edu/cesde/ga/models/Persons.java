package co.edu.cesde.ga.models;

public class Persons {
    long userId;
    String cod;
    String documentNumber;
    String firstname;
    String lastname;
    boolean status;

    public String getDocumentNumber() {
        return documentNumber;
    }


    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Persons(long userId, String cod, String documentNumber, String firstname, String lastname, boolean status) {
        this.userId = userId;
        this.cod = cod;
        this.documentNumber = documentNumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.status = status;
    }
}
