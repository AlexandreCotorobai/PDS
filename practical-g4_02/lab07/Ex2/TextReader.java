import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Queue;

public class TextReader implements ReaderInterface {
    private Queue<String> queue;
    public TextReader(String filename) {
        try{
            List<String> lines = Files.readAllLines(Paths.get(filename));
            queue = new java.util.LinkedList<String>(lines);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public String next() {
        String line = queue.poll();
        while (line != null && line.trim().isEmpty()) {
            line = queue.poll();
        }
        return line;
    }
}
