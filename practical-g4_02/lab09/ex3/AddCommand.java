package ex3;

/**
 * AddCommand
 */
public class AddCommand<E> extends Command<E> {

    public AddCommand(java.util.Collection<E> collection) {
        super(collection);
    }

    @Override
    public boolean execute(E element) {
        this.backup = element;
        return collection.add(element);
    }

    @Override
    public void undo() {
        collection.remove(this.backup);
    }
}