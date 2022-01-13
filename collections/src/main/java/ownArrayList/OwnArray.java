package ownArrayList;

public interface OwnArray<E> extends Iterable<E> {

    void add(E e);
    void delete(int index);
    E get(int index);
    int size();
    void printOwnArray();
    void update(int index, E e);

}
