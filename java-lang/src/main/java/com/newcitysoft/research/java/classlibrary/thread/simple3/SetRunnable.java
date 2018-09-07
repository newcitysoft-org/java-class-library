package com.newcitysoft.research.java.classlibrary.thread.simple3;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/4 10:30
 */
public class SetRunnable implements Runnable {

    private int x = 0;
    private Student student;

    public SetRunnable(Student student) {
        this.student = student;
    }

    @Override
    public void run() {
        while (true) {
            if(x % 2 == 0) {
                student.set("田利新", 26);
            } else {
                student.set("肖寰", 25);
            }

            x++;
        }
    }
}
