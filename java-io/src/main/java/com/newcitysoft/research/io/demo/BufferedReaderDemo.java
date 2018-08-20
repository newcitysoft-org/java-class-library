package com.newcitysoft.research.io.demo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/8/20 11:05
 */
public class BufferedReaderDemo {

    public static void main(String[] args) throws IOException {
        String path = "D:\\data\\data.txt";
//        read(path);
//        readChars(path);
        readLine(path);
    }

    private static void read(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

        int ch = 0;
        while ((ch = reader.read()) != -1) {
            System.out.print((char) ch);
        }

        reader.close();
    }

    private static void readChars(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

        int length = 0;
        char[] chars = new char[1024];
        while ((length = reader.read(chars)) != -1) {
            System.out.print(new String(chars, 0, length));
        }

        reader.close();
    }

    private static void readLine(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));

        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();
    }
}
