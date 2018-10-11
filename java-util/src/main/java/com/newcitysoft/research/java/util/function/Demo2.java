package com.newcitysoft.research.java.util.function;

import java.util.function.Function;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/10/10 17:58
 */
public class Demo2 {

    public static void main(String[] args) {
        Function<Integer, Integer> f = i -> i + 1;
        Function<Integer, Integer> g = i -> i * 2;

        Function<Integer, Integer> h = f.andThen(g);

        Integer apply = h.apply(5);
        System.out.println(apply);


        Function<Integer, Integer> compose = f.compose(g);

        Integer apply1 = compose.apply(1);
        System.out.println(apply1);
    }
}
