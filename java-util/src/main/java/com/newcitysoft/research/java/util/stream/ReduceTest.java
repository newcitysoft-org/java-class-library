package com.newcitysoft.research.java.util.stream;

import org.junit.Test;

import java.util.List;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/10/11 17:30
 */
public class ReduceTest {

    /**
     * 获取菜的总卡路里
     */
    @Test
    public void test1() {
        List<Dish> menu = Dish.menu;

        Integer sum = menu.stream().map(Dish::getCalories)
                .reduce((a, b) -> a + b).get();

        int reduce = menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);

        System.out.println(sum);
    }

    /**
     * 获取最高卡路里的菜名
     */
    @Test
    public void test2() {
        List<Dish> menu = Dish.menu;

        Integer integer = menu.stream().map(Dish::getCalories).reduce(Integer::max).get();

        System.out.println(integer);
    }

    @Test
    public void test3() {
        List<Dish> menu = Dish.menu;

        Integer reduce = menu.stream().map(d -> 1).reduce(0, Integer::sum);

        System.out.println(reduce);
    }
}
