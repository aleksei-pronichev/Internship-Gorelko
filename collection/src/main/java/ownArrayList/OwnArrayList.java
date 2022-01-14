package ownArrayList;

import java.util.Iterator;

public class OwnArrayList<E> implements MethodForOwnArray<E> {

    private E[] values;
    int countValues = 0;

    public OwnArrayList() {
        values = (E[]) new Object[10];
    }

    @Override
    public void add(E e) {

            if(countValues == values.length-1){
                createNewArr(values.length*2, e);
            }else{
                values[countValues] = e;
                countValues++;
            }

    }

    public void createNewArr(int newLength, E e) {
        E[] newArray = (E[]) new Object[newLength];
        System.arraycopy(values, 0, newArray, 0, values.length);
        values = newArray;
        values[countValues] = e;
        countValues++;
    }

    @Override
    public void delete(int index) {
            countValues--;
            E[] tempValuesPart1 = (E[]) new Object[index];
            System.arraycopy(values, 0, tempValuesPart1, 0, index);

            E[] tempValuesPart2 = (E[]) new Object[values.length - (index + 1)];
            System.arraycopy(values, index + 1, tempValuesPart2, 0, tempValuesPart2.length);

            values = (E[]) new Object[tempValuesPart1.length + tempValuesPart2.length];
            System.arraycopy(tempValuesPart1, 0, values, 0, tempValuesPart1.length);
            System.arraycopy(tempValuesPart2, 0, values, index, tempValuesPart2.length);
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return countValues;
    }

    @Override
    public void update(int index, E e) {
        values[index] = e;
    }

    @Override
    public Iterator<E> iterator() {
        return new OwnArrayIterator<>(values, countValues);
    }
}
