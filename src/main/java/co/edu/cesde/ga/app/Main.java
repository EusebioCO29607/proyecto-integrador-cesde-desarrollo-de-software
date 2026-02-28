package co.edu.cesde.ga.app;
import co.edu.cesde.ga.models.Person;
import co.edu.cesde.ga.models.Student;
import co.edu.cesde.ga.models.Teacher;

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

        Person person4 = new Person(1L, "1200", "200000001", "maria", "martinez", true);
        person4.getFirstname();

        Teacher teacher = new Teacher();
        teacher.setFirstname("jaime");
        System.out.println(teacher.toString());


        Teacher teacher2 = new Teacher(2L, "1002", "2000000001", "mario", "Paez", true);
        System.out.println(teacher2.toString());

        Teacher teacher3 = new Teacher(3L, "1003", "20000000002", "david", "casaz", true);
        System.out.println(teacher3.toString());



    }

}
