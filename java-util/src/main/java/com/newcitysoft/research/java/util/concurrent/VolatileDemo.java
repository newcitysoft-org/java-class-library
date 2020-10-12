package com.newcitysoft.research.java.util.concurrent;

/**
 * volatile 关键字demo
 *
 * volatile是JVM提供的轻量级同步工具，JVM实现同步原语操作
 * 防止编译器在不改变程序语义的前提下，进行Java指令的冲排序，JMM增加标记用于屏蔽重排序操作——内存屏障
 * 一共有以下四种内存屏障：
 * 1. StoreStore : Store1 StoreStore Store2 - 禁止上面的普通写和下面的volatile写重排序
 * 2. StoreLoad : Store1 StoreLoad Load2 - 禁止上面的volatile写和下面可能有的volatile读/写重排序
 * 3. LoadLoad : Load1 LoadLoad Load2 - 禁止下面所有的普通读与上面的volatile读重排序
 * 4. LoadStore: Load1 LoadStore Store2 - 禁止下面的普通写volatile读重排序
 *
 * JMM的保守策略：
 * volatile写
 * 1.simple read
 * 2.simple write
 * 1.StoreStore
 * 4.volatile write
 * 5.StoreLoad
 *
 * volatile读
 * 1.volatile read
 * 2.LoadLoad
 * 3.LoadStore
 * 4.simple read
 * 5.simple write
 *
 * @author : newcitysoft@163.com
 * @date : 2020-10-12 16:30
 * @version : 1.0
 */
public class VolatileDemo {
    private static volatile boolean isOver = false;

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isOver// LoadLoad LoadStore
               ) ;
            }
        });
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // StoreStore
        isOver = true;
        // StoreLoad
    }
}