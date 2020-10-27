package com.newcitysoft.research.java.util.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description
 *
 * @author : newcitysoft@163.com
 * @date : 2020-10-27 17:04
 * @version : 1.0
 */
public class LockConditionDemo {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread waitThread = new Thread(new Waiter());
        Thread signalThread = new Thread(new Signaler());

        waitThread.start();
        signalThread.start();
    }

    private static class Waiter implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                while(!flag) {
                    System.out.println(Thread.currentThread().getName() + "开始阶段，没有满足条件");
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "收到消息，满足条件");
            } finally {
                lock.unlock();
            }
        }
    }

    private static class Signaler implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try{
                flag = true;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}
