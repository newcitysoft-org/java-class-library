package com.newcitysoft.research.java.classlibrary.thread.queue;

import java.util.concurrent.BlockingQueue;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/4 10:33
 */
public class GetRunnable implements Runnable {

    private BlockingQueue<Student> queue;

    public GetRunnable(BlockingQueue<Student> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Student take = queue.take();
                System.out.println(take.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
