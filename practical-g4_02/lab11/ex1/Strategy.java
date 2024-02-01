import java.util.*;

public interface Strategy {
    public void sortS(Collection<Phone> phones, Comparator<Phone> sortBy);
}
