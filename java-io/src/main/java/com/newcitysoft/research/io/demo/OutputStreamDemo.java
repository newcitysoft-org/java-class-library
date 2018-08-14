package com.newcitysoft.research.io.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/8/14 10:30
 */
public class OutputStreamDemo {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\data\\test\\123.txt");
        write(file);
        appendWrite(file);
    }

    private static void write(File file) throws IOException {
        // 创建输出流对象
        OutputStream outputStream = new FileOutputStream(file);
        // 写数据
        String words = "hello, java io!";
        outputStream.write(words.getBytes());
        // 释放资源
        outputStream.close();
    }

    private static void appendWrite(File file) throws IOException {
        OutputStream outputStream = new FileOutputStream(file, true);

        String words = "\r\nhhhhhh";
        outputStream.write(words.getBytes());

        outputStream.close();
    }
}
