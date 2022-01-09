package ownArrayList;

import java.util.Iterator;

public class OwnArrayIterator<E> implements Iterator<E> {

    int index = 0;
    E[] values;

    public OwnArrayIterator(E[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    @Override
    public E next() {
        return values[index++];
    }

}
