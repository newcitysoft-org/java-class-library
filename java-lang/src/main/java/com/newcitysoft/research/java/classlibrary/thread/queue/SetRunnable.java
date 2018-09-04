package com.newcitysoft.research.java.classlibrary.thread.queue;

import java.util.concurrent.BlockingQueue;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/4 10:30
 */
public class SetRunnable implements Runnable {

    private int x = 0;
    private BlockingQueue<Student> queue;

    public SetRunnable(BlockingQueue<Student> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            Student student = new Student();
            if(x % 2 == 0) {
                student.setName("田利新");
                student.setAge(26);
            } else {
                student.setName("肖寰");
                student.setAge(25);
            }

            queue.offer(student);

            x++;
        }
    }
}
