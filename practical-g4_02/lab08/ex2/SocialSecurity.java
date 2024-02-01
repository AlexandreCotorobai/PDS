import java.util.*;

public class SocialSecurity {
    private static List<Person> registed_people;

    public SocialSecurity() {
        registed_people = new ArrayList<>();        
    }

    public void regist(Person person) {
        if (!registed_people.contains(person)) {
            registed_people.add(person);
            System.out.println(person.getName() + " has registed (SocialSecurity).");
        }else{
            System.out.println(person.getName() + " are already registed (SocialSecurity).)");
        }
    }

    public List<Person> getRegisted_people() {
        return registed_people;
    }
}
