package com.newcitysoft.research.io.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/8/15 9:59
 */
public class InputStreamDemo {

    public static void main(String[] args) throws IOException {
        String path = "D:\\data\\log4j\\renren-jinkong-kylin-report-config\\stdout.log";

        read(path);
        readBytes(path);
    }

    private static void read(String path) throws IOException {
        InputStream is = new FileInputStream(path);

        int line = 0;
        while ((line = is.read()) != -1) {
            System.out.print((char) line);
        }

        is.close();
    }

    private static void readBytes(String path) throws IOException {
        InputStream is = new FileInputStream(path);

        byte[] bytes = new byte[1024];
        int length = 0;
        while ((length = is.read(bytes)) != -1) {
            System.out.print(new String(bytes, 0, length));
        }

        is.close();
    }
}
