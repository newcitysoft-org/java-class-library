package com.newcitysoft.research.java.classlibrary.thread.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/4 10:34
 */
public class StudentDemo {

    public static void main(String[] args) {
        BlockingQueue<Student> queue = new ArrayBlockingQueue<>(2);

        Runnable set = new SetRunnable(queue);
        Runnable get = new GetRunnable(queue);

        Thread t1 = new Thread(set);
        Thread t2 = new Thread(get);

        t1.start();
        t2.start();
    }
}
