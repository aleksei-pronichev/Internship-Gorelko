package ownLinkedList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnLinkedListTest {

    @org.junit.jupiter.api.Test
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

    @org.junit.jupiter.api.Test
    void delete() {
        OwnLinkedList<String> ownList = new OwnLinkedList<>();
        ownList.add("Andersen");
        ownList.delete(0);
        assertEquals(0, ownList.size());
    }

    @org.junit.jupiter.api.Test
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

    @org.junit.jupiter.api.Test
    void size() {
        OwnLinkedList<String> ownList = new OwnLinkedList<>();
        ownList.add("Andersen1");
        ownList.add("Andersen2");
        ownList.add("Andersen3");
        ownList.add("Andersen4");
        assertEquals(4, ownList.size());
    }

    @org.junit.jupiter.api.Test
    void update() {
        OwnLinkedList<String> ownList = new OwnLinkedList<>();
        ownList.add("Andersen1");
        ownList.add("Andersen2");
        ownList.add("Andersen3");
        ownList.update(1, "NewAndersen");
        assertEquals("NewAndersen", ownList.get(1));
    }

    @org.junit.jupiter.api.Test
    void iterator() {
        OwnLinkedList<String> ownList = new OwnLinkedList<>();
        ownList.add("Andersen");
        ownList.add("Andersen");
        ownList.add("Andersen");
        ownList.add("Andersen");

        for (String text : ownList){
            assertEquals("Andersen", text);
        }
    }
}