package com.newcitysoft.research.java.classlibrary.thread;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/10/8 14:28
 */
public class ThreadLocalTest {
//    ThreadLocal<Long> longThreadLocal = new ThreadLocal<>();
//    ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();

    ThreadLocal<Long> longThreadLocal = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
            return Thread.currentThread().getId();
        }
    };

    ThreadLocal<String> stringThreadLocal = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return super.initialValue();
        }
    };


    public void set() {
        longThreadLocal.set(Thread.currentThread().getId());
        stringThreadLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longThreadLocal.get();
    }

    public String getString() {
        return stringThreadLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalTest test = new ThreadLocalTest();

//        test.set();

        System.out.println(test.getLong());
        System.out.println(test.getString());

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                test.set();
                System.out.println(test.getLong());
                System.out.println(test.getString());
            };
        };

        thread1.start();
        thread1.join();

        System.out.println(test.getLong());
        System.out.println(test.getString());
    }
}
