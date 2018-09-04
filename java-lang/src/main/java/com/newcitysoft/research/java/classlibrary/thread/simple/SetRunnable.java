package com.newcitysoft.research.java.classlibrary.thread.simple;

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
            synchronized(student) {
                if(x % 2 == 0) {
                    this.student.setName("田利新");
                    this.student.setAge(26);
                } else {
                    this.student.setName("肖寰");
                    this.student.setAge(25);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                x++;
            }
        }
    }
}
