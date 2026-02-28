package co.edu.cesde.ga.models;

public class Teacher  extends Person{
    public Teacher(){
        super();
    }

    public Teacher(long userId, String code, String documentNumber, String firstname, String lastname, boolean status) {
        super(userId, code, documentNumber, firstname, lastname, status);

    }
    @Override
    public String toString(){
        return "Teacher{}" +super.toString();


    }

}
