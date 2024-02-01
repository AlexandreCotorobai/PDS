import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class BasicPrinterAdapter implements AdvancedPrinterInterface {

    private BasicPrinter printer;

    private LinkedBlockingQueue<Document> printQueue;

    public BasicPrinterAdapter() {
        this.printer = new BasicPrinter();
        this.printQueue = new LinkedBlockingQueue<>();
    }

    public int print(Document doc) {
        printQueue.add(doc);
        printAll();
        return printQueue.size();
    }

    public List<Integer> print(List<Document> docs) {
        List<Integer> list = new ArrayList<>();
        for (Document document : docs) {
            list.add(print(document));
        }
        printAll();
        return list;
    }

    public void showQueuedJobs() {
        if (printQueue.isEmpty()) {
            System.out.println("No spooled jobs.");
            return;
        }
        int i = 1;
        System.out.println("Spooled jobs:");
        for (Document document : printQueue) {
            System.out.println("  * Job " + i++ + ": " + document);
        }
    }

    public boolean cancelJob(int jobId) {
        LinkedBlockingQueue<Document> temp = new LinkedBlockingQueue<>();
        boolean found = false;
        for (int i = 0; i < printQueue.size(); i++) {
            Document document = printQueue.poll();
            if (i == jobId - 1) {
                found = true;
                continue;
            }
            temp.add(document);
        }
        printQueue = temp;
        return found;
    }

    public void cancelAll() {
        printQueue.clear();
    }

    private void printAll() {
        if (printQueue.isEmpty()) {
            System.out.println("No spooled jobs.");
            return;
        }
        while (!printQueue.isEmpty()) {
            boolean success = printer.print(printQueue.peek().getContent());
            if (success) {
                printQueue.poll();
            } else {
                printer.refill();
            }
        }

    }

}
