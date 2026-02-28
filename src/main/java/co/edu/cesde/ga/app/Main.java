package co.edu.cesde.ga.app;
import co.edu.cesde.ga.app.Main;
import co.edu.cesde.ga.models.Person;

public class Main {
    public static void main(String[] args){
        System.out.println("HELLO WORD");
        Person person = new Person();
        Person person2 = new Person();
        Person person3 = new Person();

        person.setFirstname("sergio");
        person.getFirstname();
        person2.setFirstname("diego");
        person2.getFirstname();
        person3.setFirstname("vanessa");
        person3.getFirstname();




    }

}
