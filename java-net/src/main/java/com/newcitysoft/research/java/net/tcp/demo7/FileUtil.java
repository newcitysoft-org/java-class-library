package com.newcitysoft.research.java.net.tcp.demo7;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/14 15:49
 */
public class FileUtil {

    public static byte[] InputStream2ByteArray(String filePath) throws IOException {
        InputStream in = new FileInputStream(filePath);
        byte[] data = toByteArray(in);
        in.close();

        return data;
    }

    private static byte[] toByteArray(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024 * 4];
        int n = 0;

        while ((n = in.read(buffer)) != -1) {
            out.write(buffer, 0, n);
        }

        return out.toByteArray();
    }

    public static void byteToFile(byte[] contents, String filePath) {
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream output = null;
        try {
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(contents);
            bis = new BufferedInputStream(byteInputStream);
            File file = new File(filePath);
            // 获取文件的父路径字符串
            File path = file.getParentFile();
            if (!path.exists()) {
                System.out.println("文件夹不存在，创建。path={}");
                boolean isCreated = path.mkdirs();
                if (!isCreated) {
                    System.out.println("创建文件夹失败，path=" + path);
                }
            }
            fos = new FileOutputStream(file);
            // 实例化OutputString 对象
            output = new BufferedOutputStream(fos);
            byte[] buffer = new byte[1024];
            int length = bis.read(buffer);
            while (length != -1) {
                output.write(buffer, 0, length);
                length = bis.read(buffer);
            }
            output.flush();
        } catch (Exception e) {
            System.out.println("输出文件流时抛异常，filePath={}");
        } finally {
            try {
                bis.close();
                fos.close();
                output.close();
            } catch (IOException e0) {
                System.out.println("文件处理失败，filePath={}");
            }
        }
    }
}
