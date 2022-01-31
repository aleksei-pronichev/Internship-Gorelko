package com.cache;

import java.io.IOException;

public class TwoLevelCache<Key, Value> implements Cache<Key, Value> {

    private final RamCache<Key, Value> ramCache;
    private final MemoryCache<Key, Value> memoryCache;
    private int maxCountCallForRam = 5;

    public TwoLevelCache() {
        this.ramCache = new RamCache<Key, Value>();
        this.memoryCache = new MemoryCache<Key, Value>();
    }

    @Override
    public void add(Key key, Value value) {

        ramCache.add(key, value);

    }

    @Override
    public void clean() {

        ramCache.clean();
        memoryCache.clean();

    }

    @Override
    public int size() {
        return ramCache.size() + memoryCache.size();
    }

    @Override
    public Value get(Key key) throws IOException, ClassNotFoundException {

        if (ramCache.containsKey(key)) {

            if (ramCache.getNumberOfCall(key) == maxCountCallForRam) {
                memoryCache.add(key, ramCache.get(key));
                ramCache.deleteObject(key);
            }

            return ramCache.get(key);
        }

        if (memoryCache.containsKey(key)) {
            return memoryCache.get(key);
        }

        return null;
    }

    @Override
    public void deleteObject(Key key) throws IOException, ClassNotFoundException {

        if (ramCache.get(key) != null) {
            ramCache.deleteObject(key);
        }

        if (memoryCache.get(key) != null) {
            memoryCache.deleteObject(key);
        }

    }
}
