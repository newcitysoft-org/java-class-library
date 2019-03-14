package com.newcitysoft.research.java.util.concurrent;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.function.BiFunction;

/**
 * description
 *
 * @author : newcitysoft@163.com
 * @date : 2019-03-14 11:52
 * @version : 1.0
 */
public class CompletableFutureTest {


    @Test
    public void testAsync() {
        long startTime = System.currentTimeMillis();

        Future<Long> add = add(2, 5);

        long endTime = System.currentTimeMillis();
        System.out.println("并行执行时间：" + (endTime - startTime) / 1000);

        try {
            System.out.println("异步执行结果：" + add.get(2, TimeUnit.SECONDS));

            endTime = System.currentTimeMillis();
            System.out.println("最终完成时间：" + (endTime - startTime) / 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static Future<Long> add(long a1, long a2) {
        CompletableFuture<Long> completableFuture = new CompletableFuture<>();

        new Thread(() -> {
            try {
                completableFuture.complete(delaySum((a, b) -> a + b, a1, a2));
        } catch (Exception e) {
            completableFuture.completeExceptionally(e);
        }
    }).start();

        return completableFuture;
}

    public static Long delaySum(BiFunction<Long, Long, Long> function, long a1, long a2) throws InterruptedException {
        Thread.sleep(1000);
        return function.apply(a1, a2);
    }

    @Test
    public void testSupplyAsync() {
        CompletableFuture<Long> longFuture = (CompletableFuture<Long>) supplyAsyncAdd(4, 7);

        longFuture.exceptionally(ex -> {
            System.out.println("Exception caught: " + ex.getMessage());
            return 0L;
        }).thenAccept(result -> {
            System.out.println("result: " + result);
        });

        try {
            System.out.println(longFuture.get(1, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static Future<Long> supplyAsyncAdd(long a1, long a2) {
        CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Long sum = delaySum((a, b) -> a + b, a1, a2);
                return sum;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        return completableFuture;
    }



}
