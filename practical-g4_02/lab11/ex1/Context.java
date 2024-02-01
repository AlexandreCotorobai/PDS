import java.util.*;

public class Context {
    private Strategy strategy;
    private Collection<Phone> phones;


    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(Comparator<Phone> sortby) {
        strategy.sortS(this.phones, sortby);
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void addPhone(Phone phone) {
        if (this.phones == null) {
            this.phones = new ArrayList<>();
        }
        this.phones.add(phone);
    }

    public Collection<Phone> getPhoneList() {
        return this.phones;
    }

    public void printPhoneList() {
        for (Phone phone : this.phones) {
            System.out.println(phone);
        }
    }

}
