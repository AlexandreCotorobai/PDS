public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();

        editor.write("Hello");
        editor.write("Hello World");
        editor.write("Hello World!!!");
        // editor.read();
        editor.readLast();
    }
}
