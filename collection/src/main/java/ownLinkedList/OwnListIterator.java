package ownLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OwnListIterator<E> implements Iterator<E> {

    Node<E> values;

    public OwnListIterator(Node<E> values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return values != null;
    }

    @Override
    public E next() {
        if (!hasNext()) throw new NoSuchElementException();
        E temp = values.current;
        values = values.next;
        return temp;
    }
}
