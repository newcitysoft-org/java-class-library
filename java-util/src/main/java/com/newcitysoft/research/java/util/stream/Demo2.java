package com.newcitysoft.research.java.util.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * flatMap方法是把一个流中的每个值都换成另一个流，然后把所有的流连接起来成为一个流。
 *
 * @author lixin.tian@renren-inc.com
 * @date 2018/10/11 16:13
 */
public class Demo2 {

    public static void main(String[] args) {
        String[] words = {"Hello", "World"};

        List<String> collect = Arrays
                .stream(words)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(collect);
    }
}
