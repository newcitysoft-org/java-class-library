package com.newcitysoft.research.java.util.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/10/11 16:23
 */
public class FlatMapTest {

    /**
     * 给定一个数字列表，返回一个由每个数的平方构成的列表
     */
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        List<Integer> result = list.stream().map(i -> i * i).collect(Collectors.toList());

        System.out.println(result);
    }

    /**
     * 给定两个数列表，返回所有的数对
     * 例如，给定列表[1,2,3]和列表[3,4]
     *
     */
    @Test
    public void test2() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> collect = numbers1.stream()
                .flatMap(
                        i -> numbers2.stream().map(j -> new int[]{i, j})
                )
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    /**
     * 扩展test2，返回总和能被3整除的数对
     */
    @Test
    public void test3() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> collect = numbers1.stream()
                .flatMap(
                        i -> numbers2.stream().map(j -> new int[]{i, j})
                )
                .filter(arr -> (arr[0] + arr[1]) % 3 == 0)
                .collect(Collectors.toList());

        collect.forEach(ints -> {
            System.out.println(ints[0] + "," + ints[1]);
        });
    }

    /**
     * 扩展test2，返回总和能被3整除的数对
     */
    @Test
    public void test32() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> collect = numbers1.stream()
                .flatMap(
                        i -> numbers2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[]{i, j})
                )
                .collect(Collectors.toList());

        collect.forEach(ints -> {
            System.out.println(ints[0] + "," + ints[1]);
        });
    }
}
