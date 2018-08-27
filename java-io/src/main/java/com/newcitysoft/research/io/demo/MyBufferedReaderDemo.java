package com.newcitysoft.research.io.demo;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/8/24 15:16
 */
public class MyBufferedReaderDemo {

    public static void main(String[] args) throws IOException {
        MyBufferedReader reader = new MyBufferedReader(new FileReader("d:\\data\\123.txt"));

        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
