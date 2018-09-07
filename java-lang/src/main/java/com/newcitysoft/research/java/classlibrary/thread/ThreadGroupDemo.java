package com.newcitysoft.research.java.classlibrary.thread;

import java.util.stream.IntStream;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/7 9:34
 */
public class ThreadGroupDemo {

    public static void main(String[] args) {
//        demo1();
        demo2();
    }

    private static void demo1() {
        Thread thread = new Thread(() -> {
            IntStream.range(1, 100).forEach(i -> System.out.println(i));
        });

        thread.start();

        System.out.println(thread.getThreadGroup().getName());
    }

    private static void demo2() {
        ThreadGroup group = new ThreadGroup("group");

        Thread thread1 = new Thread(group, () -> {
            IntStream.range(1, 100).forEach(i -> {
                String concat = Thread.currentThread().getName().concat(":").concat(String.valueOf(i));
                System.out.println(concat);
            });
        }, "thread1");

        Thread thread2 = new Thread(group, () -> {
            IntStream.range(1, 100).forEach(i -> {
                String concat = Thread.currentThread().getName().concat(":").concat(String.valueOf(i));
                System.out.println(concat);
            });
        }, "thread2");

        thread1.start();
        thread2.start();

        System.out.println(thread1.getThreadGroup().getName());
        System.out.println(thread2.getThreadGroup().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getName());
    }

    private static void demo3() {
        ThreadGroup group = new ThreadGroup("group");

        Thread thread1 = new Thread(group, () -> {
            IntStream.range(1, 100).forEach(i -> {
                String concat = Thread.currentThread().getName().concat(":").concat(String.valueOf(i));
                System.out.println(concat);
            });
        }, "thread1");

        Thread thread2 = new Thread(group, () -> {
            IntStream.range(1, 100).forEach(i -> {
                String concat = Thread.currentThread().getName().concat(":").concat(String.valueOf(i));
                System.out.println(concat);
            });
        }, "thread2");

        group.setDaemon(true);

        thread1.start();
        thread2.start();

        System.out.println(thread1.getThreadGroup().getName());
        System.out.println(thread2.getThreadGroup().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getName());
    }
}
