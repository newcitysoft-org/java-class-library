package com.newcitysoft.research.java.util.concurrent.thread;

/**
 * 上面的例子中daemodThread run方法中是一个while死循环，会一直打印,
 * 但是当main线程结束后daemonThread就会退出所以不会出现死循环的情况。
 * main线程先睡眠800ms保证daemonThread能够拥有一次时间片的机会，
 * 也就是说可以正常执行一次打印“i am alive”操作和一次finally块中"finally block"操作。
 * 紧接着main 线程结束后，daemonThread退出，这个时候只打印了"i am alive"并没有打印finnal块中的。
 * 因此，这里需要注意的是守护线程在退出的时候并不会执行finnaly块中的代码，所以将释放资源等操作不要放在finnaly块中执行，这种操作是不安全的
 */
public class DaemonDemo {
    public static void main(String[] args) {
        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("i am alive");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("finally block");
                    }
                }
            }
        });
        daemonThread.setDaemon(true);
        daemonThread.start();
        //确保main线程结束前能给daemonThread能够分到时间片
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}