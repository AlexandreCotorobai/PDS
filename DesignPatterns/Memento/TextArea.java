public class TextArea {
    private String text;

    public TextArea() {
        text = "";
    }

    public void set(String text) {
        this.text = text;
    }

    public String get() {
        return text;
    }

    public Memento save() {
        return new Memento(this.text);
    }

    public void restore(Memento memento) {
        this.text = memento.getText();
    }

    public static class Memento {
        private String text;

        public Memento(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}
