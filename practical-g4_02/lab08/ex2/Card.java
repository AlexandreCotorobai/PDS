import java.util.*;

public class Card {
    private static Map<Integer, Person> registed_people;
    private static int count=0;

    public Card() {
        registed_people = new HashMap<>();        
    }

    public void create(Person person) {
        if (!registed_people.containsValue(person)) {
            registed_people.put(count, person);
            count++;
            System.out.println(person.getName() + " has created (Card).");
        }else{
            System.out.println(person.getName() + " are already created (Card).");
        }
    }
}
