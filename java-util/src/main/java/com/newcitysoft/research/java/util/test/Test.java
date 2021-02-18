package com.newcitysoft.research.java.util.test;

import lombok.SneakyThrows;

public class Test {
    private static volatile boolean flag = false;
    private static volatile int start = 1;
    private static volatile int end = 100;

    public void printThread1() throws InterruptedException {
        while (end >0) {
            synchronized (this) {
                if(flag) {
                    this.wait();
                } else {
                    this.notify();
                    System.out.println(Thread.currentThread().getName() + ",i:" + start);
                    start++;
                    flag = true;
                    end--;
                }
            }
        }
    }

    public void printThread2() throws InterruptedException {
        while (end > 0) {
            synchronized (this) {
                if(!flag) {
                    this.wait();
                } else {
                    this.notify();
                    System.out.println(Thread.currentThread().getName() + ",i:" + start);
                    start++;
                    flag = false;
                    end--;
                }
            }
        }
    }

    private static class Thread1 extends Thread {

        private Test test;

        public Thread1(Test test) {
            this.test = test;
        }

        @SneakyThrows
        @Override
        public void run() {
            test.printThread1();
        }
    }

    private static class Thread2 extends Thread {

        private Test test;

        public Thread2(Test test) {
            this.test = test;
        }

        @SneakyThrows
        @Override
        public void run() {
            test.printThread2();
        }
    }

    public static void main(String[] args) {
        Test test = new Test();

        Thread1 thread1 = new Thread1(test);
        Thread2 thread2 = new Thread2(test);

        thread1.start();
        thread2.start();
    }
}
