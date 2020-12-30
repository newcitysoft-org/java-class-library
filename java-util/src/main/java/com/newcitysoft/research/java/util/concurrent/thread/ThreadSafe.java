package com.newcitysoft.research.java.util.concurrent.thread;

/**
 * description
 *
 * @author : newcitysoft@163.com
 * @date : 2020-12-30 10:06
 * @version : 1.0
 */
public class ThreadSafe extends Thread {

    @Override
    public void run() {
        //非阻塞过程中通过判断中断标志来退出
        while (!isInterrupted()){
            try{
                //阻塞过程捕获中断异常来退出
                Thread.sleep(5*1000);
            }catch(InterruptedException e){
                e.printStackTrace();
                //捕获到异常之后，执行 break 跳出循环
                break;
            }
        }
    }
}