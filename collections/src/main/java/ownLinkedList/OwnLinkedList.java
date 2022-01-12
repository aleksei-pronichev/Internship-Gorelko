package ownLinkedList;

import java.util.Iterator;

public class OwnLinkedList<E> implements OwnList<E> {

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;

    @Override
    public void add(E e) {
        if (size == 0) {
            size++;
            addFirstValue(e);
        } else if (size == 1) {
            size++;
            addSecondValue(e);
        } else if (size > 1) {
            size++;
            addMoreTwoValue(e);
        }
    }

    public void addFirstValue(E e) {
        Node<E> node1 = new Node<>();
        node1.setPrev(null);
        node1.setNext(null);
        node1.setCurrent(e);
        this.firstNode = node1;
        this.lastNode = node1;
    }

    public void addSecondValue(E e) {
        Node<E> node2 = new Node<>();
        node2.setPrev(firstNode);
        node2.setNext(null);
        node2.setCurrent(e);

        Node<E> node1 = new Node<>();
        node1.setPrev(null);
        node1.setNext(node2);
        node1.setCurrent(firstNode.getCurrent());

        this.firstNode = node1;
        this.lastNode = node2;
    }

    public void addMoreTwoValue(E e) {
        Node<E> node1 = lastNode;
        Node<E> node2 = new Node<>();
        node2.setPrev(lastNode);
        node2.setNext(null);
        node2.setCurrent(e);
        this.lastNode = node2;
        node1.setNext(node2);
    }

    @Override
    public void delete(int index) {
        if (index == 0) {
            delForZeroIndex(index);
        } else if (index == 1) {
            delForFirstIndex(index);
        } else if (index == size - 1) {
            delForLastIndex(index);
        } else {
            delForMiddleIndex(index);
        }
        size--;
    }

    public void delForZeroIndex(int index) {
        if (size > 2) {
            firstNode.getNext().setPrev(null);
            firstNode = firstNode.getNext();
        } else if (size == 2) {
            lastNode.setNext(null);
            lastNode.setPrev(null);
            firstNode = lastNode;
        } else if (size == 1) {
            firstNode = null;
            lastNode = null;
        }
    }

    public void delForFirstIndex(int index) {
        if (size == 3) {
            Node<E> tempNode = firstNode.getNext().getNext();
            tempNode.setPrev(firstNode);
            firstNode.setNext(tempNode);
        } else if (size == 2) {
            firstNode.setPrev(null);
            firstNode.setNext(null);
            lastNode = firstNode;
        }
    }

    public void delForLastIndex(int index) {
        if (index == 2) {
            lastNode = firstNode.getNext();
            lastNode.setNext(null);
        } else {
            Node<E> tempNode = firstNode.getNext();
            for (int i = 1; i < index; i++) {
                tempNode = tempNode.getNext();
            }
            tempNode.setNext(null);
            lastNode = tempNode;
        }
    }

    public void delForMiddleIndex(int index) {
        Node<E> tempNode = firstNode;
        Node<E> tempNode1 = firstNode;
        Node<E> tempNode2 = firstNode;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.getNext();
            tempNode1 = tempNode.getPrev();
            tempNode2 = tempNode.getNext();
        }
        tempNode1.setNext(tempNode2);
        tempNode2.setPrev(tempNode1);
    }

    @Override
    public E get(int index) {

        if (index == 0) {
            return firstNode.getCurrent();
        } else if (index > 0) {
            Node<E> tempNode = firstNode.getNext();
            for (int i = 1; i < index; i++) {
                tempNode = tempNode.getNext();
            }
            return tempNode.getCurrent();
        }
        return firstNode.getCurrent();

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void update(int index, E e) {

        if (index == 0) {
            firstNode.setCurrent(e);
        } else {
            Node<E> tempNode = firstNode.getNext();
            for (int i = 1; i < index; i++) {
                tempNode = tempNode.getNext();
            }
            tempNode.setCurrent(e);
        }
    }

    @Override
        public Iterator<E> iterator() {
        return new OwnListIterator<>(firstNode);
    }
}
