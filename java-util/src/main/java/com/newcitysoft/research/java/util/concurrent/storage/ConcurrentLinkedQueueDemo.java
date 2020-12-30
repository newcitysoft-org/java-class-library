package com.newcitysoft.research.java.util.concurrent.storage;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * description
 *
 * @author : tianlixin001@ke.com
 * @date : 2020-11-12 10:20
 * @version : 1.0
 */
public class ConcurrentLinkedQueueDemo {

    private static final ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) {
        queue.offer("1");
        queue.offer("2");
//        for(int i = 0; i< 10; i++) {
//            new Thread(() -> queue.offer(Thread.currentThread().getName())).start();
//        }
    }
}
