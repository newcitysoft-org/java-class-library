package com.newcitysoft.research.java.util.concurrent;

import java.util.concurrent.locks.StampedLock;

/**
 * description
 *
 * @author : tianlixin001@ke.com
 * @version : 1.0
 * @date : 2020-04-14 14:14
 */
public class StampedLockDemo {

    private static final StampedLock sl = new StampedLock();

    private static void readTemp() {
        // 乐观读
        long stamp = sl.tryOptimisticRead();
        // 读入方法局部变量
        // 校验stamp
        if (!sl.validate(stamp)) {
            // 升级为悲观读锁
            stamp = sl.readLock();
            try {
                // 读入方法局部变量 .....
            } finally { //释放悲观读锁 sl.unlockRead(stamp);
            }
        }
        //使用方法局部变量执行业务操作
    }

    private static void writeTemp() {
        long stamp = sl.writeLock();
        try {
            // 写共享变量 ......
        } finally {
            sl.unlockWrite(stamp);
        }
    }
}
