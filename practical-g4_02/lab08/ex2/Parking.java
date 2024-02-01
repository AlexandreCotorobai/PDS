import java.util.*;

public class Parking {
    private static List<Person> registed_people;

    public Parking() {
        registed_people = new ArrayList<>();        
    }

    public void allow(Person person) {
        if (!registed_people.contains(person)) {
            registed_people.add(person);
            System.out.println(person.getName() + " has allowed to park here.");
        }else{
            System.out.println(person.getName() + " are already allowed to park here.");
        }
    }
}
