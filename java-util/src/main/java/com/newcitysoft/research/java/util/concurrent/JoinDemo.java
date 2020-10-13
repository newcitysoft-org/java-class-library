package com.newcitysoft.research.java.util.concurrent;

/**
 * 线程等待，当前线程等待其他线程结束后，再运行以后的代码
 * 方式：thread.join
 */
public class JoinDemo {
    public static void main(String[] args) {
        Thread previousThread = Thread.currentThread();
        for (int i = 1; i <= 10; i++) {
            Thread curThread = new JoinThread(previousThread);
            curThread.start();
            previousThread = curThread;
        }
    }

    static class JoinThread extends Thread {
        private Thread thread;

        public JoinThread(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
                System.out.println(thread.getName() + " terminated.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}