package ownLinkedList;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OwnLinkedListTest {

    @Test
    void add() {
        OwnLinkedList<String> ownList = new OwnLinkedList<>();
        ownList.add("Andersen1");
        ownList.add("Andersen2");
        ownList.add("Andersen3");
        ownList.add("Andersen4");
        assertEquals("Andersen1", ownList.get(0));
        assertEquals("Andersen2", ownList.get(1));
        assertEquals("Andersen3", ownList.get(2));
        assertEquals("Andersen4", ownList.get(3));
    }

    @Test
    void delete() {
        OwnLinkedList<String> ownList = new OwnLinkedList<>();
        ownList.add("Andersen");
        ownList.delete(0);
        assertEquals(0, ownList.size());
    }

    @Test
    void get() {
        OwnLinkedList<String> ownList = new OwnLinkedList<>();
        ownList.add("Andersen1");
        ownList.add("Andersen2");
        ownList.add("Andersen3");
        ownList.add("Andersen4");
        assertEquals("Andersen1", ownList.get(0));
        assertEquals("Andersen2", ownList.get(1));
        assertEquals("Andersen3", ownList.get(2));
        assertEquals("Andersen4", ownList.get(3));
    }

    @Test
    void size() {
        OwnLinkedList<String> ownList = new OwnLinkedList<>();
        ownList.add("Andersen1");
        ownList.add("Andersen2");
        ownList.add("Andersen3");
        ownList.add("Andersen4");
        assertEquals(4, ownList.size());
    }

    @Test
    void update() {
        OwnLinkedList<String> ownList = new OwnLinkedList<>();
        ownList.add("Andersen1");
        ownList.add("Andersen2");
        ownList.add("Andersen3");
        ownList.update(1, "NewAndersen");
        assertEquals("NewAndersen", ownList.get(1));
    }

    @Test
    void iterator() {
        OwnLinkedList<String> ownList = new OwnLinkedList<>();
        ownList.add("Andersen");
        Iterator<String> iter = ownList.iterator();

        boolean actual = iter.hasNext();

        assertTrue(actual);
    }
}