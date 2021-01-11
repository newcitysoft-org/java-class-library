package com.newcitysoft.research.java.util.concurrent;

/**
 * description
 *
 * @author : tianlixin001@ke.com
 * @date : 2021-01-11 11:39
 * @version : 1.0
 */
public class ThreadTakeTurnPrint {

    private volatile static boolean flag = false;
    private volatile static int i = 1;
    private volatile static int k = 100;

    public void printThread1(){
        try{
            while (k > 0){
                synchronized (this){
                    if(flag){
                        this.wait();
                    }else{
                        this.notify();
                        System.out.println(Thread.currentThread().getName() + "----------> i = " + i);
                        i ++;
                        flag = true;
                        k --;
                    }
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void printThread2(){
        try{
            while (k > 0){
                synchronized (this){
                    if(!flag){
                        this.wait();
                    }else{
                        this.notify();
                        System.out.println(Thread.currentThread().getName() + "----------> i = " + i);
                        i = i + 1;
                        flag = false;
                        k --;
                    }
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static class ThreadA extends Thread{
        private ThreadTakeTurnPrint data;

        public ThreadA(ThreadTakeTurnPrint data){
            this.data = data;
        }

        @Override
        public void run() {
            data.printThread1();
        }
    }

    public static class ThreadB extends Thread{
        private ThreadTakeTurnPrint data;

        public ThreadB(ThreadTakeTurnPrint data){
            this.data = data;
        }

        @Override
        public void run() {
            data.printThread2();
        }
    }


    public static void main(String[] args) {
        ThreadTakeTurnPrint data = new ThreadTakeTurnPrint();
        ThreadA threadA = new ThreadA(data);
        ThreadB threadB = new ThreadB(data);
        threadA.start();
        threadB.start();
    }
}
