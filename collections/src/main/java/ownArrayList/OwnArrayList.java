package ownArrayList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class OwnArrayList<E> implements OwnArray<E> {
    @Override
    public String toString() {
        return Arrays.toString(values);
    }

    private E[] values;
    private int countValues = 0;

    public OwnArrayList() {
        values = (E[]) new Object[10];
    }

    @Override
    public void add(E e) {

        if (countValues == values.length - 1) {
            createNewArr(values.length * 2, e);
        } else {
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

        if (countValues == index + 1) {
            values[index] = null;
        } else {
            E[] tempValues = values;
            values = (E[]) new Object[tempValues.length - 1];
            System.arraycopy(tempValues, 0, values, 0, index);
            int countForEnter = tempValues.length - index - 1;
            System.arraycopy(tempValues, index + 1, values, index, countForEnter);
        }
        countValues--;

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

    @Override
    public void printOwnArray(){
        String input = Arrays.toString(values);
        Stream<String> stream = Arrays.stream(input.split( "," ));
        stream
                .filter(x -> x.indexOf("null")==-1)
                .map(x -> x.replace("[", "").replace("]", "").replace(" ", ""))
                .forEach(x -> System.out.print(x + " "));

    }

}
