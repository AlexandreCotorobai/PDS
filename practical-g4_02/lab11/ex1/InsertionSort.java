import java.util.*;

public class InsertionSort implements Strategy {

    public void sortS(Collection<Phone> phones, Comparator<Phone> sortby) {
        Phone[] phoneArray = phones.toArray(new Phone[0]);
        int n = phoneArray.length;

        for (int i = 1; i < n; i++) {
            Phone key = phoneArray[i];
            int j = i - 1;

            while (j >= 0 && sortby.compare(phoneArray[j], key) > 0) {
                phoneArray[j + 1] = phoneArray[j];
                j--;
            }

            phoneArray[j + 1] = key;
        }

        phones.clear();
        for (Phone phone : phoneArray) {
            phones.add(phone);
        }
    }
}

