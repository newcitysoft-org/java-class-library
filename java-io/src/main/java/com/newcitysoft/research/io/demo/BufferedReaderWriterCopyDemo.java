package com.newcitysoft.research.io.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/8/20 11:28
 */
public class BufferedReaderWriterCopyDemo {

    public static void main(String[] args) throws IOException {
        String srcPath = "D:\\data\\data.txt";
        String descPath = "data.txt";
//        copy0(srcPath, descPath);
        copy(srcPath, descPath);
    }

    public static void copy(String srcPath, String descPath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(srcPath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(descPath));

        String line = null;
        while ((line = reader.readLine()) != null) {
            writer.write(line);
            writer.newLine();
            writer.flush();
        }

        writer.close();
        reader.close();
    }

    public static void copy0(String srcPath, String descPath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(srcPath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(descPath));

        int length = 0;
        char[] chars = new char[1024];
        while ((length = reader.read(chars)) != -1) {
            writer.write(new String(chars, 0, length));
            writer.flush();
        }

        writer.close();
        reader.close();
    }

}
