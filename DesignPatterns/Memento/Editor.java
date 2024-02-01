import java.util.*;

public class Editor {
    private Deque<TextArea.Memento> textHistory;
    private TextArea textArea;

    public Editor() {
        textHistory = new LinkedList<>();
        textArea = new TextArea();
    }

    public void write(String text) {
        textArea.set(text);
        textHistory.push(textArea.save());
    }

    public void read() {
        for (TextArea.Memento memento : textHistory) {
            System.out.println(memento.getText());
        }
    }

    public void readLast() {
        System.out.println(textHistory.peek().getText());
    }

    public void undo() {
        if (textHistory.isEmpty()) {
            System.out.println("Nothing to undo");
            return;
        }
        textArea.restore(textHistory.pop());

    }
}
