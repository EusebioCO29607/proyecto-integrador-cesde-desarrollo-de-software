package co.edu.cesde.ga.models;

import java.time.LocalDate;

public class Student extends Person {

    private String birthDate;

    public Student() {
        super();
    }

    public Student(long userId, String code, String documentNumber, String firstname, String lastname, boolean status, String birthDate) {
        super(userId, code, documentNumber, firstname, lastname, status);
        this.birthDate = birthDate;
    }

    public Student(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Student" + super.toString() +
        "birthDate='" + birthDate + '\'';
    }
}









