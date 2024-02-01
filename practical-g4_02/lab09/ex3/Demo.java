package ex3;

public class Demo {
    public static void main(String[] args) {
        java.util.Collection<String> collection = new java.util.ArrayList<>();
        Command<String> addCommand = new AddCommand<>(collection);
        Command<String> removeCommand = new RemoveCommand<>(collection);

        addCommand.execute("Hello");
        addCommand.execute("World");
        System.out.println(collection);

        removeCommand.execute("Hello");
        System.out.println(collection);

        removeCommand.undo();
        System.out.println(collection);

        addCommand.undo();
        System.out.println(collection);
    }
}
