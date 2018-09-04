package com.newcitysoft.research.java.classlibrary.thread.simple;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/4 10:33
 */
public class GetRunnable implements Runnable {

    private Student student;

    public GetRunnable(Student student) {
        this.student = student;
    }

    @Override
    public void run() {
        while (true) {
            synchronized(student) {
                System.out.println(student.toString());
            }
        }
    }
}
