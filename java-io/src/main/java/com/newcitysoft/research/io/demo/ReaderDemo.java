package com.newcitysoft.research.io.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/8/20 10:38
 */
public class ReaderDemo {

    public static void main(String[] args) throws IOException {
        String path = "D:\\data\\data.txt";
//        read(path);
        readBytes(path);
    }

    private static void read(String path) throws IOException {
        InputStreamReader reader = new InputStreamReader(new FileInputStream(path));

        int ch = 0;
        while ((ch = reader.read()) != -1) {
            System.out.print((char) ch);
        }

        reader.close();
    }

    private static void readBytes(String path) throws IOException {
        InputStreamReader reader = new InputStreamReader(new FileInputStream(path));

        int length = 0;
        char[] chars = new char[1024];
        while ((length = reader.read(chars)) != -1) {
            System.out.print(new String(chars, 0, length));
        }

        reader.close();
    }
}
