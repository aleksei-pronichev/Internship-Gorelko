package ownArrayList;

public interface Methods<E> extends Iterable<E> {

    void add(E e);
    void delete(int index);
    E get(int index);
    int size();
    void update(int index, E e);

}
