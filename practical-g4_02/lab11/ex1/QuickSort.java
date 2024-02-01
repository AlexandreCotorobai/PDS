import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class QuickSort implements Strategy {

    @Override
    public void sortS(Collection<Phone> phones, Comparator<Phone> sortby) {
        List<Phone> phoneList = (List<Phone>) phones;
        quickSort(phoneList, 0, phoneList.size() - 1, sortby);
    }

    private void quickSort(List<Phone> phones, int low, int high, Comparator<Phone> sortby) {
        if (low < high) {
            int partitionIndex = partition(phones, low, high, sortby);

            quickSort(phones, low, partitionIndex - 1, sortby);
            quickSort(phones, partitionIndex + 1, high, sortby);
        }
    }

    private int partition(List<Phone> phones, int low, int high, Comparator<Phone> sortby) {
        Phone pivot = phones.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (sortby.compare(phones.get(j), pivot) < 0) {
                i++;
                swap(phones, i, j);
            }
        }

        swap(phones, i + 1, high);

        return i + 1;
    }

    private void swap(List<Phone> phones, int i, int j) {
        Phone temp = phones.get(i);
        phones.set(i, phones.get(j));
        phones.set(j, temp);
    }
}
