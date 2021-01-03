package com.newcitysoft.research.java.util.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 回环栅栏demo
 * CountDownLatch 和 CyclicBarrier 都能够实现线程之间的等待，只不过它们侧重点不同;
 * CountDownLatch 一般用于某个线程 A 等待若干个其他线程执行完任务之后，它才执行;
 * 而 CyclicBarrier 一般用于一组线程互相等待至某个状态，然后这一组线程再同时
 * 执行;另外，CountDownLatch 是不能够重用的，而 CyclicBarrier 是可以重用的。
 * Semaphore其实和锁有点类似，它一般用于控制对某组资源的访问权限。
 *
 * @author : newcitysoft@163.com
 * @date : 2021-01-03 09:42
 * @version : 1.0
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N);
        for(int i=0;i<N;i++) {
            new Writer(barrier).start();
        }
    }

    static class Writer extends Thread {

        private CyclicBarrier cyclicBarrier;

        Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务，比如数据操作");
        }
    }
}
