package com.cache;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class MemoryCacheTest {

    MemoryCache<String, String> memoryCache = new MemoryCache<>();

    @Test
    void add() throws IOException, ClassNotFoundException {
        memoryCache.add("one", "1");
        assertEquals("1", memoryCache.get("one"));
    }

    @Test
    void clean() throws IOException {
        memoryCache.add("one", "1");
        memoryCache.add("two", "2");
        memoryCache.clean();

        assertEquals(0, memoryCache.size());
    }

    @Test
    void size() throws IOException {
        memoryCache.add("one", "1");
        memoryCache.add("two", "2");

        assertEquals(2, memoryCache.size());
    }

    @Test
    void get() throws IOException, ClassNotFoundException {
        memoryCache.add("one", "1");
        memoryCache.add("two", "2");

        assertEquals("2", memoryCache.get("two"));
    }

    @Test
    void deleteObject() throws IOException {
        memoryCache.add("one", "1");
        memoryCache.add("two", "2");
        memoryCache.deleteObject("two");

        assertEquals(1, memoryCache.size());
    }

    @Test
    void getNumberOfCall() throws IOException, ClassNotFoundException {
        memoryCache.add("one", "1");
        memoryCache.get("one");
        memoryCache.get("one");
        memoryCache.get("one");

        assertEquals(4, memoryCache.getNumberOfCall("one"));
    }

    @Test
    void containsKey() throws IOException {

        memoryCache.add("one", "1");
        assertTrue(memoryCache.containsKey("one"));

    }
}