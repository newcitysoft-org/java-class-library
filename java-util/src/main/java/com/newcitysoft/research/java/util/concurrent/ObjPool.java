package com.newcitysoft.research.java.util.concurrent;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * 对象池
 *
 * @author : newcitysoft@163.com
 * @date : 2020-01-17 16:21
 * @version : 1.0
 */
public class ObjPool<T, R> {
    final List<T> pool;
    /**
     * 用信号量实现限流器
     */
    final Semaphore sem;

    /**
     * 构造函数
     *
     * @param size
     * @param t
     */
    ObjPool(int size, T t){
        pool = new Vector<T>(){};
        for(int i = 0; i<size; i++){
            pool.add(t);
        }
        sem = new Semaphore(size);
    }

    /**
     * 利用对象池的对象，调用func
     *
     * @param func
     * @return
     * @throws InterruptedException
     */
    R exec(Function<T,R> func) {
        T t = null;
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t = pool.remove(0);
            return func.apply(t); }
        finally {
            pool.add(t);
            sem.release();
        }
    }

    public static void main(String[] args) {
        // 创建对象池
        ObjPool<Long, String> pool = new ObjPool<>(10, 2L);
        // 通过对象池获取t，之后执行
        pool.exec(t -> {
            System.out.println(t);
            return t.toString();
        });
    }

}