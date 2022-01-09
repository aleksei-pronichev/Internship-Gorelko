package ownArrayList;

import java.util.Iterator;

public class OwnArrayList<E> implements Methods<E> {

    private E[] values;

    public OwnArrayList() {
        values = (E[]) new Object[0];
    }

    @Override
    public void add(E e) {

        try {

            E[] tempValues = values;
            int lengthValues = values.length;
            values = (E[]) new Object[lengthValues + 1];
            values[values.length - 1] = e;
            System.arraycopy(tempValues, 0, values, 0, tempValues.length);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void delete(int index) {

        try {

            E[] tempValuesPart1 = (E[]) new Object[index];
            System.arraycopy(values, 0, tempValuesPart1, 0, index);

            E[] tempValuesPart2 = (E[]) new Object[values.length - (index + 1)];
            System.arraycopy(values, index + 1, tempValuesPart2, 0, tempValuesPart2.length);

            values = (E[]) new Object[tempValuesPart1.length + tempValuesPart2.length];
            System.arraycopy(tempValuesPart1, 0, values, 0, tempValuesPart1.length);
            System.arraycopy(tempValuesPart2, 0, values, index, tempValuesPart2.length);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void update(int index, E e) {
        values[index] = e;
    }

    @Override
    public Iterator<E> iterator() {
        return new OwnArrayIterator<>(values);
    }
}
