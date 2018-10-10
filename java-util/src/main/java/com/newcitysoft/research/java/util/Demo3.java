package com.newcitysoft.research.java.util;

import java.util.function.Function;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/10/10 18:07
 */
public class Demo3 {

    public static void main(String[] args) {
        Function<String, String> addHeader = Letter::addHeader;

        Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling)
                .andThen(Letter::addFooter);

        String result = transformationPipeline.apply("Hi!This is my first labda code!");
        System.out.println(result);
    }
}
