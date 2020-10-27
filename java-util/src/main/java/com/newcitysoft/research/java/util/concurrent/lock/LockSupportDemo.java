package com.newcitysoft.research.java.util.concurrent.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * description
 *
 * @author : newcitysoft@163.com
 * @date : 2020-10-27 17:35
 * @version : 1.0
 */
public class LockSupportDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "被唤醒");
        });
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.unpark(thread);
    }
}
