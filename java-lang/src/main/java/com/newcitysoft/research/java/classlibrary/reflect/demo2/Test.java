package com.newcitysoft.research.java.classlibrary.reflect.demo2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用反射，向List<Integer>添加字符串类型数据
 *
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/18 10:25
 */
public class Test {

    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        // 获取集合的字节码对象
        Class<? extends List> clazz = list.getClass();
        // 获取add方法
        Method add = clazz.getMethod("add", Object.class);
        // 添加数据
        add.invoke(list, "Hello");
        add.invoke(list, "Java");
        // 输出集合
        System.out.println(list);
    }
}
