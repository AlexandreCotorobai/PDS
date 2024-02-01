import java.util.*;

public class Insurance {
    private static List<Person> registed_people;

    public Insurance() {
        registed_people = new ArrayList<>();        
    }

    public void regist(Person person) {
        if (!registed_people.contains(person)) {
            registed_people.add(person);
            System.out.println(person.getName() + " has registed (Insurance).");
        }else{
            System.out.println(person.getName() + " are already registed (Insurance).");
        }
    }

}
