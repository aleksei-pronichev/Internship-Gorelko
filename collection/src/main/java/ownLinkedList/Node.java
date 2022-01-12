package ownLinkedList;

public class Node<E> {

    Node<E> prev;
    E current;
    Node<E> next;

    public Node() {
    }

    public Node(Node<E> prev, E current, Node<E> next) {
        this.prev = prev;
        this.current = current;
        this.next = next;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    public E getCurrent() {
        return current;
    }

    public void setCurrent(E current) {
        this.current = current;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
