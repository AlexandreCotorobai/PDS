import java.util.*;

public class Main {
    public static void main(String[] args) {
        Context context = new Context(new InsertionSort());
    
        context.addPhone(new Phone("Snapdragon", "12MP", 1000, 128));
        context.addPhone(new Phone("Exynos", "16MP", 800, 64));
        context.addPhone(new Phone("A14 Bionic", "20MP", 1200, 256));
        context.addPhone(new Phone("Kirin", "8MP", 600, 32));
    
        context.executeStrategy(Comparator.comparing(Phone::getPrice));
        System.out.println("Sorting by price using Insertion Sort:");
        context.printPhoneList();

        context.setStrategy(new BubbleSort());
        context.executeStrategy((a,b) -> a.getStorage() - b.getStorage() > 0 ? 1 : -1);
        System.out.println("Sorting by storage using Bubble Sort:");
        context.printPhoneList();

        context.setStrategy(new QuickSort());
        context.executeStrategy(Comparator.comparing(Phone::getProcessor));
        System.out.println("Sorting by processor using Quick Sort:");
        context.printPhoneList();
    }
    
}
