import java.util.ArrayList;
import java.util.List;

public class PrinterTest {
    
    private static void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Advanced Printer Test");
        AdvancedPrinterInterface p = new AdvancedPrinter();

        List<Document> docs = new ArrayList<Document>();
        docs.add(new Document("text1.txt"));
        docs.add(new Document("text2.txt"));
        docs.add(new Document("text3.txt"));

        p.print(docs.get(0));   // print first document only
        pause(2000);            // wait for a while

        p.print(docs);
        p.showQueuedJobs();
        pause(4000);            // wait for a while

        p.print(docs);
        p.cancelJob(6);
        p.showQueuedJobs();
        pause(4000);            // wait for a while

        p.print(docs);
        p.cancelAll();
        p.showQueuedJobs();

        pause(2000);            // wait for a while
        System.out.println("Basic Printer Test");

        AdvancedPrinterInterface p1 = new BasicPrinterAdapter();

        docs.add(new Document("text1.txt"));
        docs.add(new Document("text2.txt"));
        docs.add(new Document("text3.txt"));

        p1.print(docs.get(0));   // print first document only
        pause(2000);            // wait for a while

        p1.print(docs);
        p1.showQueuedJobs();
        pause(4000);            // wait for a while

        p1.print(docs);
        p1.cancelJob(6);
        p1.showQueuedJobs();
        pause(4000);            // wait for a while

        p1.print(docs);
        p1.cancelAll();
        p1.showQueuedJobs();

        pause(2000);            // wait for a while
    }
}
