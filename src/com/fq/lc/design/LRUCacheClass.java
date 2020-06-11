package com.fq.lc.design;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lgq
 * @date 2020/6/11
 */
public class LRUCacheClass<K, V> extends LinkedHashMap<K, V> {

    int cacheSize;

    LRUCacheClass(int capacity) {
        super((int)Math.ceil(capacity / 0.75), 0.75f, true);
        this.cacheSize = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize;
    }

}
