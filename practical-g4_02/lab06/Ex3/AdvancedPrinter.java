import  java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class AdvancedPrinter implements AdvancedPrinterInterface {

    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/ExecutorService.html
    class PrinterService implements Runnable {
        private final LinkedBlockingQueue<PrintJob> printQueue;
        private final ExecutorService pool;
     
        // este serviço simula a fila de impressão e a impressão de um documento de cada vez
        public PrinterService() {
                printQueue = new LinkedBlockingQueue<>();
                pool = Executors.newFixedThreadPool(1);
        }
     
        public void run() { // run the service
            try {
                for (;;) {
                    PrintJob j = printQueue.take();
                    pool.submit(j).get();
                }
            } catch (java.util.concurrent.RejectedExecutionException ex) {
                System.out.println("Job rejected by spool: service shutting down?");
            } catch (ExecutionException e) {
                System.out.println("Error");
                e.printStackTrace();
            } catch (InterruptedException ex) {
            this.shutdownAndAwaitTermination();
            }
        }

        public int newPrintJob(Document doc) {
            // TODO: adiciona 'print job' à fila de impressão
            PrintJob job = new PrintJob(doc);
            printQueue.add(job);
            return job.getID();
        }

        public boolean cancelJob(int job) {
           // TODO: cancela 'print job', se existir na fila

            LinkedBlockingQueue<PrintJob> templist = new LinkedBlockingQueue<>();
            for (int i = 0; i < printQueue.size(); i++) {
                if (printQueue.peek().getID() == job) {
                    printQueue.poll();
                } else {
                    templist.add(printQueue.poll());
                }
            }
            printQueue.clear();
            printQueue.addAll(templist);
            return true;
        }
    
        void shutdownAndAwaitTermination() {
            pool.shutdown(); // Disable new tasks from being submitted
            try {
            // Wait a while for existing tasks to terminate
            if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                pool.shutdownNow(); // Cancel currently executing tasks
                // Wait a while for tasks to respond to being cancelled
                if (!pool.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("Spool did not terminate.");
            }
            } catch (InterruptedException ie) {
                // (Re-)Cancel if current thread also interrupted
                pool.shutdownNow();
                printQueue.clear();
                // Preserve interrupt status
                Thread.currentThread().interrupt();
            }
        }

        public LinkedBlockingQueue<PrintJob> getPrintQueue() {
            return printQueue;
        }
    }

    private PrinterService spool;

    public AdvancedPrinter() {
        this.spool = new PrinterService();
        new Thread(this.spool).start();
    }

    // TODO: implementar métodos

    @Override
    public int print(Document doc) {
        // TODO Auto-generated method stub
        System.out.println("Spooling 1 document.");
        return spool.newPrintJob(doc);
    }

    @Override
    public List<Integer> print(List<Document> docs) {
        // TODO Auto-generated method stub
        System.out.println("Spooling " + docs.size() + " documents.");
        List<Integer> list = new ArrayList<>();
        for (Document document : docs) {
            list.add(spool.newPrintJob(document));
        }
        return list;
    }

    @Override
    public void showQueuedJobs() {
        LinkedBlockingQueue<PrintJob> list = spool.getPrintQueue();
        if (list.isEmpty()) {
            System.out.println("No spooled jobs.");
            return;
        }
        int i = 1;
        System.out.println("Spooled jobs:");
        for (PrintJob printJob : list) {
            System.out.println("  * " + printJob);
        }
    }

    @Override
    public boolean cancelJob(int jobId) {
        if (spool.cancelJob(jobId)) {
            System.out.println("Job " + jobId + " cancelled.");
            return true;
        }
        System.out.println("Job " + jobId + " not found.");
        return false;
    }

    @Override
    public void cancelAll() {
        spool.shutdownAndAwaitTermination();
    }

}
