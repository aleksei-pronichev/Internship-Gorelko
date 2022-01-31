package com.cache;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoLevelCacheTest {

    TwoLevelCache<String, String> twoLevelCache = new TwoLevelCache<>();

    @Test
    void add() throws IOException, ClassNotFoundException {
        twoLevelCache.add("one", "1");

        assertEquals("1", twoLevelCache.get("one"));

    }

    @Test
    void clean() throws IOException {
        twoLevelCache.add("one", "1");
        twoLevelCache.add("two", "2");
        twoLevelCache.clean();

        assertEquals(0, twoLevelCache.size());
    }

    @Test
    void size() throws IOException {
        twoLevelCache.add("one", "1");
        twoLevelCache.add("two", "2");

        assertEquals(2, twoLevelCache.size());
    }

    @Test
    void get() throws IOException, ClassNotFoundException {
        twoLevelCache.add("one", "1");

        assertEquals("1", twoLevelCache.get("one"));
    }

    @Test
    void deleteObject() throws IOException, ClassNotFoundException {
        twoLevelCache.add("one", "1");
        twoLevelCache.add("two", "2");

        twoLevelCache.deleteObject("two");

        assertEquals(1, twoLevelCache.size());
    }
}