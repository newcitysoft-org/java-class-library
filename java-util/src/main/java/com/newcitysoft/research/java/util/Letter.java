package com.newcitysoft.research.java.util;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/10/10 18:05
 */
public class Letter {

    public static String addHeader(String text) {
        return "From Raoul, Mario and Alan: " + text;
    }

    public static String addFooter(String text) {
        return text + " Kind regards";
    }

    public static String checkSpelling(String text) {
        return text.replaceAll("labda", "lambda");
    }
}
