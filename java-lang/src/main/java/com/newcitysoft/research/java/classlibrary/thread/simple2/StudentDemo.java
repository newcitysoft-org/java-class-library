package com.newcitysoft.research.java.classlibrary.thread.simple2;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/4 10:34
 */
public class StudentDemo {

    public static void main(String[] args) {
        Student student = new Student();

        Runnable set = new SetRunnable(student);
        Runnable get = new GetRunnable(student);

        Thread t1 = new Thread(set);
        Thread t2 = new Thread(get);

        t1.start();
        t2.start();
    }
}
