package com.newcitysoft.research.io.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/8/20 10:56
 */
public class ReaderWriterCopyDemo {

    public static void main(String[] args) throws IOException {
        String srcPath = "D:\\data\\data.txt";
        String descPath = "data.txt";
        copy(srcPath, descPath);
    }

    private static void copy(String srcPath, String descPath) throws IOException {
        InputStreamReader reader = new InputStreamReader(new FileInputStream(srcPath));
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(descPath));

        int length = 0;
        char[] chars = new char[1024];
        while ((length = reader.read(chars)) != -1) {
            writer.write(chars, 0, length);
        }

        writer.close();
        reader.close();
    }
}
