package ownArrayList;

import java.util.Iterator;

public class OwnArrayIterator<E> implements Iterator<E> {

    private int index = -1;
    private final int countValues;
    private final E[] values;

    public OwnArrayIterator(E[] values, int countValues) {
        this.values = values;
        this.countValues = countValues-1;
    }

    @Override
    public boolean hasNext() {
        return index < countValues;
    }

    @Override
    public E next() {
        index++;
        return values[index];

    }

}
