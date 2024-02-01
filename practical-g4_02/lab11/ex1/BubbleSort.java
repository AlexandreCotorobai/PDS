import java.util.*;

public class BubbleSort implements Strategy {

    public void sortS(Collection<Phone> phones, Comparator<Phone> sortby) {
        Phone[] phoneArray = phones.toArray(new Phone[0]);
        int n = phoneArray.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortby.compare(phoneArray[j], phoneArray[j + 1]) > 0) {
                    Phone temp = phoneArray[j];
                    phoneArray[j] = phoneArray[j + 1];
                    phoneArray[j + 1] = temp;
                }
            }
        }

        phones.clear();
        for (Phone phone : phoneArray) {
            phones.add(phone);
        }
    }
}

