package com.newcitysoft.research.io.demo;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/8/20 11:00
 */
public class BufferedWriterDemo {

    public static void main(String[] args) throws IOException {
        String path = "D:\\data\\456.txt";
        String content = "Hello java ";

        write(path, content);
    }

    private static void write(String path, String content) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)));

        for (int i = 0; i < 10; i++) {
            bw.write(content + i);
            bw.newLine();
            bw.flush();
        }

        bw.close();
    }
}
