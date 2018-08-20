package com.newcitysoft.research.io.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.stream.IntStream;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/8/20 10:41
 */
public class WriterDemo {

    public static void main(String[] args) throws IOException {
        String path = "D:\\data\\123.txt";
        String content = "Hello Java!!!";

        write(path, content);
    }

    private static void write(String path, String content) throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(path));

        IntStream.range(0, 10).forEach(i -> {
            try {
                osw.write(content + i + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        osw.close();
    }
}
