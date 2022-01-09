package ownLinkedList;

import java.util.Iterator;

public class OwnLinkedList<E> extends Object implements MethodForOwnList<E> {

    Node<E> firstNode;
    Node<E> lastNode;
    int size = 0;

    @Override
    public void add(E e) {

        if (size == 0) {
            size++;

            Node<E> node1 = new Node<>();
            node1.prev = null;
            node1.next = null;
            node1.current = e;
            this.firstNode = node1;
            this.lastNode = node1;

        } else if (size == 1) {

            size++;

            Node<E> node2 = new Node<>();
            node2.prev = firstNode;
            node2.next = null;
            node2.current = e;

            Node<E> node1 = new Node<>();
            node1.prev = null;
            node1.next = node2;
            node1.current = firstNode.current;

            this.firstNode = node1;
            this.lastNode = node2;

        } else if (size > 1) {

            size++;

            Node<E> node1 = lastNode;

            Node<E> node2 = new Node<>();
            node2.prev = lastNode;
            node2.next = null;
            node2.current = e;

            this.lastNode = node2;
            try {
                node1.next = node2;
            } catch (Exception e1) {

            }
        }
    }

    @Override
    public void delete(int index) {

        if (index == 0) {
            if (size > 2) {
                firstNode.next.prev = null;
                firstNode = firstNode.next;
            } else if (size == 2) {
                lastNode.next = null;
                lastNode.prev = null;
                firstNode = lastNode;
            } else if (size == 1) {
                firstNode = null;
                lastNode = null;
            }

        } else if (index == 1) {

            if (size == 3) {
                Node<E> tempNode = firstNode.next.next;
                tempNode.prev = firstNode;
                firstNode.next = tempNode;
            } else if (size == 2) {
                firstNode.prev = null;
                firstNode.next = null;
                lastNode = firstNode;
            }


        } else if (index == size - 1) {

            if (index == 2) {
                lastNode = firstNode.next;
                lastNode.next = null;
                firstNode.next = lastNode;
            } else {
                Node<E> tempNode = firstNode.next;
                for (int i = 1; i < index; i++) {
                    tempNode = tempNode.next;
                }
                tempNode.next = null;
                lastNode = tempNode;
            }

        } else {
            Node<E> tempNode = firstNode;
            Node<E> tempNode1 = firstNode;
            Node<E> tempNode2 = firstNode;
            for (int i = 0; i < index; i++) {
                tempNode = tempNode.next;
                tempNode1 = tempNode.prev;
                tempNode2 = tempNode.next;
            }
            tempNode1.next = tempNode2;
            tempNode2.prev = tempNode1;
        }
        size--;

    }

    @Override
    public E get(int index) {

        if (index == 0) {
            return firstNode.current;
        } else if (index > 0) {
            Node<E> tempNode = firstNode.next;
            for (int i = 1; i < index; i++) {
                tempNode = tempNode.next;
            }
            return tempNode.current;
        }
        return firstNode.current;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void update(int index, E e) {

        if (index == 0) {
            firstNode.current = e;
        } else {
            Node<E> tempNode = firstNode.next;
            for (int i = 1; i < index; i++) {
                tempNode = tempNode.next;
            }
            tempNode.current = e;
        }
    }

    @Override
        public Iterator<E> iterator() {
        return new OwnListIterator<>(firstNode);
    }
}
