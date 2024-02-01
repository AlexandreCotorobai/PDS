package ex3;

import java.util.Collection;

public abstract class Command<E> {
    protected java.util.Collection<E> collection;
    protected E backup;

    Command(Collection<E> collection) {
        this.collection = collection;
    }

    public abstract boolean execute(E element);
    public abstract void undo();
}
