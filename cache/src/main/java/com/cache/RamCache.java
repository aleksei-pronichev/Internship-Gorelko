package com.cache;

import java.util.HashMap;
import java.util.TreeMap;

public class RamCache<Key, Value> implements Cache<Key, Value> {

    private final HashMap<Key, Value> hashMap;
    private final TreeMap<Key, Integer> callCounterMap;

    public RamCache() {
        hashMap = new HashMap<Key, Value>();
        callCounterMap = new TreeMap<Key, Integer>();
    }

    @Override
    public void add(Key key, Value value) {
        callCounterMap.put(key, 1);
        hashMap.put(key, value);
    }

    @Override
    public void clean() {
        hashMap.clear();
        callCounterMap.clear();
    }

    @Override
    public int size() {
        return hashMap.size();
    }

    @Override
    public Value get(Key key) {
        if (hashMap.containsKey(key)) {
            int count = callCounterMap.get(key);
            count = count + 1;
            callCounterMap.put(key, count);
            return hashMap.get(key);
        }
        return null;
    }

    @Override
    public void deleteObject(Key key) {
        if (hashMap.containsKey(key)) {
            hashMap.remove(key);
            callCounterMap.remove(key);
        }
    }

    public int getNumberOfCall(Key key) {
        if (hashMap.containsKey(key)) {
            return callCounterMap.get(key);
        }
        return 0;
    }

    public boolean containsKey(Key key) {
        return hashMap.containsKey(key);
    }

}
