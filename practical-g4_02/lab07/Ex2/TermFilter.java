import java.util.LinkedList;
import java.util.Queue;

public class TermFilter extends ReaderDec {
    private Queue<String> queue;

    public TermFilter(ReaderInterface wrappee) {
        super(wrappee);
        queue = new LinkedList<String>();
    }
    
    @Override
    public boolean hasNext() {
        if (queue.isEmpty()) {
            boolean hasNext = wrappee.hasNext();
            if (hasNext) {
                String line = wrappee.next();
                queue = new LinkedList<String>();
                for (String word : line.split(" ")) {
                    queue.add(word);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public String next() {
        return queue.poll();
    }

}
