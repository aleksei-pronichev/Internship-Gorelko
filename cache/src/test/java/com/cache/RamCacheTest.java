package com.cache;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RamCacheTest {

    RamCache<String, String> ramCache = new RamCache<>();

    @Test
    void add() {
        ramCache.add("one", "1");
        assertEquals("1", ramCache.get("one"));
    }

    @Test
    void clean() {
        ramCache.add("one", "1");
        ramCache.add("two", "2");
        ramCache.clean();

        assertEquals(0, ramCache.size());
    }

    @Test
    void size() {
        ramCache.add("one", "1");
        ramCache.add("two", "2");

        assertEquals(2, ramCache.size());
    }

    @Test
    void get() {
        ramCache.add("one", "1");
        ramCache.add("two", "2");

        assertEquals("2", ramCache.get("two"));
    }

    @Test
    void deleteObject() {
        ramCache.add("one", "1");
        ramCache.add("two", "2");
        ramCache.deleteObject("two");

        assertEquals(1, ramCache.size());
    }

    @Test
    void getNumberOfCall() {
        ramCache.add("one", "1");
        ramCache.get("one");
        ramCache.get("one");
        ramCache.get("one");

        assertEquals(4, ramCache.getNumberOfCall("one"));
    }

    @Test
    void containsKey() {

        ramCache.add("one", "1");
        assertTrue(ramCache.containsKey("one"));

    }
}