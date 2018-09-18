package com.newcitysoft.research.java.classlibrary.reflect;

import java.lang.reflect.Constructor;
import java.util.Arrays;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/17 17:27
 */
public class Demo1 {

    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("com.newcitysoft.research.java.classlibrary.reflect.Student");

        String s = clazz.toGenericString();
        System.out.println(s);

        Constructor[] constructors = clazz.getDeclaredConstructors();
        Arrays.stream(constructors).forEach(System.out::println);
    }
}
