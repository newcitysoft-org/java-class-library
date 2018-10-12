package com.newcitysoft.research.java.util.stream;

import org.junit.Test;

import java.util.stream.IntStream;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/10/12 15:22
 */
public class StreamTest2 {

    /**
     * 原始类型流特化
     */
    @Test
    public void test() {
        int sum = StreamTest.getDataList()
                .stream()
                .mapToInt(Transaction::getValue)
                .sum();

        System.out.println(sum);
    }

    @Test
    public void test2() {
        IntStream intStream = IntStream.range(1, 100)
                .filter(i -> i % 2 == 0);

        System.out.println(intStream.count());

        intStream = IntStream.rangeClosed(1, 100)
                .filter(i -> i % 2 == 0);

        System.out.println(intStream.count());
    }
}
