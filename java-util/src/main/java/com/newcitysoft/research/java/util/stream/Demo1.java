package com.newcitysoft.research.java.util.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/10/11 10:22
 */
public class Demo1 {

    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        // 调用list的sort方法
        menu.sort(Comparator.comparing(Dish::getCalories));
        System.out.println("排序后："+ menu);
        // 转换为流
        List<String> collect = menu.stream().filter(d -> d.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("一系列流操作：" + collect);
        // 分组
        Map<Dish.Type, List<Dish>> collect1 = menu.stream().collect(groupingBy(Dish::getType));
        // 计算高卡路里的食物数量
        long count = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .distinct()
                .limit(3)
                .count();
        System.out.println(count);

        List<Dish> collect2 = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        System.out.println(collect2);

        // 筛选前两道荤菜
        List<Dish> collect3 = menu.stream().filter(dish -> !dish.isVegetarian()).limit(2).collect(Collectors.toList());
        System.out.println("前两道荤菜：" + collect3);
        // 计算每道菜的名称长度
        List<Integer> collect4 = menu.stream().map(Dish::getName).map(String::length).collect(Collectors.toList());
        System.out.println("每道菜的名称长度:" + collect4);
    }
}
