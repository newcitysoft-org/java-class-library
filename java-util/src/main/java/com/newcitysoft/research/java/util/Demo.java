package com.newcitysoft.research.java.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/10/10 17:44
 */
public class Demo {

    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();
        // No.1
        appleList.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        // No.2
        appleList.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
        // No.3
        appleList.sort(comparing(Apple::getWeight));
        // No.4
        appleList.sort(comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getCountry)
        );

    }
}
