package com.cache;

import java.io.*;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.UUID;

public class MemoryCache<Key, Value> implements Cache<Key, Value> {

    private final HashMap<Key, String> hashMap;
    private final TreeMap<Key, Integer> callCounterMap;

    public MemoryCache() {
        hashMap = new HashMap<Key, String>();
        callCounterMap = new TreeMap<Key, Integer>();
    }

    @Override
    public void add(Key key, Value value) throws IOException {

        String pathToObject;
        pathToObject = "temp/" + UUID.randomUUID().toString() + ".temp";

        File tempFolder = new File("temp/");
        if (!tempFolder.exists()) {
            tempFolder.mkdirs();
        }

        FileOutputStream fileOutputStream = new FileOutputStream(pathToObject);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(value);
        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.flush();
        fileOutputStream.close();

        callCounterMap.put(key, 1);
        hashMap.put(key, pathToObject);

    }

    @Override
    public void clean() {
        for (Key key : hashMap.keySet()) {
            File deletingFile = new File(hashMap.get(key));
            deletingFile.delete();
        }
        hashMap.clear();
        callCounterMap.clear();
    }

    @Override
    public int size() {
        return hashMap.size();
    }

    @Override
    public Value get(Key key) throws IOException, ClassNotFoundException {
        if (hashMap.containsKey(key)) {
            String filePath = hashMap.get(key);
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Value objectDeSerialization = (Value) objectInputStream.readObject();
            int count = callCounterMap.get(key);
            callCounterMap.put(key, ++count);
            objectInputStream.close();
            fileInputStream.close();
            return objectDeSerialization;
        }
        return null;
    }

    @Override
    public void deleteObject(Key key) {

        File deletedFile = new File(hashMap.get(key));
        deletedFile.delete();
        hashMap.remove(key);
        callCounterMap.remove(key);

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
