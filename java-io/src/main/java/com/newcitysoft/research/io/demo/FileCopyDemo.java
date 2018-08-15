package com.newcitysoft.research.io.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/8/15 10:05
 */
public class FileCopyDemo {

    public static void main(String[] args) throws IOException {
        String fromPath = "D:\\software\\staruml.zip";
        String toPath = "staruml.zip";

//
        long start = System.currentTimeMillis();
//        copy(fromPath, toPath);
        copyBytes(fromPath, toPath);
        long end = System.currentTimeMillis();
        long range = end - start;
        System.out.println(range);
    }

    private static void copy(String fromPath, String toPath) throws IOException {
        InputStream is = new FileInputStream(fromPath);
        OutputStream os = new FileOutputStream(toPath);

        int line = 0;
        while ((line = is.read()) != -1) {
            os.write(line);
        }

        os.close();
        is.close();
    }

    private static void copyBytes(String fromPath, String toPath) throws IOException {
        InputStream is = new FileInputStream(fromPath);
        OutputStream os = new FileOutputStream(toPath);

        byte[] bytes = new byte[1024];
        int length = 0;
        while ((length = is.read(bytes)) != -1) {
            os.write(bytes, 0, length);
        }

        os.close();
        is.close();
    }
}
