package ex3;

public class RemoveCommand<E> extends Command<E> {

    public RemoveCommand(java.util.Collection<E> collection) {
        super(collection);
    }

    @Override
    public boolean execute(E element) {
        this.backup = element;
        return collection.remove(element);
    }

    @Override
    public void undo() {
        collection.add(this.backup);
    }
}
