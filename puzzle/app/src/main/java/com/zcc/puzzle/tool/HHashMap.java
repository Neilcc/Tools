package com.zcc.puzzle.tool;

import java.util.HashMap;

public class HHashMap<K, V> extends HashMap<K, V> {

    public V getOrDefault(K k, V d) {
        V dd = get(k);
        if (dd == null) {
            return d;
        } else {
            return dd;
        }
    }
}
