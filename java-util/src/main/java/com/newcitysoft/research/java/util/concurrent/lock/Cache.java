package com.newcitysoft.research.java.util.concurrent.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWrite Cache
 *
 * @author : newcitysoft@163.com
 * @date : 2020-01-17 16:43
 * @version : 1.0
 */
public class Cache<K,V> {

    final Map<K, V> map = new HashMap<>();

    final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    final Lock readLock = readWriteLock.readLock();

    final Lock writeLock = readWriteLock.writeLock();

    public V get(K k) {
        try {
            readLock.lock();
            return map.get(k);
        } finally {
            readLock.unlock();
        }
    }

    public V put(K k, V v) {
        try {
            writeLock.lock();
            return map.put(k, v);
        } finally {
            writeLock.unlock();
        }
    }
}
