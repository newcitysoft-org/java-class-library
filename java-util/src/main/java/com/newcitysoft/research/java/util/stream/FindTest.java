package com.newcitysoft.research.java.util.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/10/11 17:21
 */
public class FindTest {

    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        Optional<Integer> first = list.stream().map(i -> i * i)
                .filter(i -> i % 3 == 0)
                .findFirst();

        first.ifPresent(System.out::print);
    }

    @Test
    public void test2() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        Optional<Integer> first = list.parallelStream().map(i -> i * i)
                .filter(i -> i % 3 == 0)
                .findFirst();

        first.ifPresent(System.out::print);
    }

    @Test
    public void test3() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        Optional<Integer> first = list.parallelStream().map(i -> i * i)
                .filter(i -> i % 3 == 0)
                .findAny();

        first.ifPresent(System.out::print);
    }
}
