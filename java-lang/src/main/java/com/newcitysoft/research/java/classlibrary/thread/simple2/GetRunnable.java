package com.newcitysoft.research.java.classlibrary.thread.simple2;

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
                if(!student.isFlag()) {
                    try {
                        student.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(student.toString());

                student.setFlag(false);
                student.notify();
            }
        }
    }
}
