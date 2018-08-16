package com.newcitysoft.research.io.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/8/16 10:05
 */
public class BufferedStreamDemo {

    public static void main(String[] args) throws IOException {
        String srcPath = "D:\\data\\test\\123.txt";
        String descPath = "789.txt";
        read(srcPath);
        write("456.txt", "你好！");
        copy(srcPath, descPath);
    }

    private static void read(String path) throws IOException {
        long start = System.currentTimeMillis();

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));

        byte[] bytes = new byte[1024];
        int length = 0;
        while ((length = bis.read(bytes)) != -1) {
            System.out.print(new String(bytes, 0 ,length));
        }

        bis.close();

        long end = System.currentTimeMillis();

        System.out.println();
        System.out.println("读取文件用时：" + (end - start));
    }

    private static void write(String path, String content) throws IOException {
        long start = System.currentTimeMillis();

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));

        bos.write(content.getBytes());

        bos.close();

        long end = System.currentTimeMillis();

        System.out.println("写文件用时：" + (end - start));
    }

    private static void copy(String srcPath, String descPath) throws IOException {
        long start = System.currentTimeMillis();

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcPath));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(descPath));

        byte[] bytes = new byte[1024];
        int length = 0;
        while ((length = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, length);
        }

        bos.close();
        bis.close();

        long end = System.currentTimeMillis();

        System.out.println("复制文件用时：" + (end - start));
     }
}
