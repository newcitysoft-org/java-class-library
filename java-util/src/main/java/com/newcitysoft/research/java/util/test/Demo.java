package com.newcitysoft.research.java.util.test;

public class Demo {

    private static volatile int flag = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new ThreadA();
        Thread t2 = new ThreadB();
        Thread t3 = new ThreadC();
        t1.start();
        t2.start();
        t3.start();
    }

    private static class ThreadA extends Thread {

        @Override
        public void run() {
            Thread.interrupted();

            while (true){
                synchronized (lock) {
                    if(flag == 0) {
                        System.out.println(Thread.currentThread().getName() + ":A");
                        flag++;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private static class ThreadB extends Thread {
        @Override
        public void run() {
            while (true){
                synchronized (lock) {
                    if(flag ==1) {
                        System.out.println(Thread.currentThread().getName() + ":B");
                        flag++;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private static class ThreadC extends Thread {
        @Override
        public void run() {
            while (true){
                synchronized (lock) {
                    if(flag ==2) {
                        System.out.println(Thread.currentThread().getName() + ":C");
                        flag = 0;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
