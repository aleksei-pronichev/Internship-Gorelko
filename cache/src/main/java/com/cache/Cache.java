package com.cache;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Cache<Key, Value> {

    void add(Key key, Value value) throws IOException;

    void clean();

    int size();

    Value get(Key key) throws IOException, ClassNotFoundException;

    void deleteObject(Key key) throws IOException, ClassNotFoundException;

}
