package com.newcitysoft.research.java.classlibrary;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 *
 * 中国字符编码表
 *      GBK
 *      GB2312
 *      GB18030
 * utf-8 最多用三个字节存储
 *
 * 兼容ASCII编码（一个字节）
 * 国际编码Unicode（两个字节）
 *
 * @author lixin.tian@renren-inc.com
 * @date 2018/8/16 10:30
 */
public class StringDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "你好！hello";
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));
        bytes = str.getBytes("unicode");
        System.out.println(new String(bytes, "unicode"));
    }
}
