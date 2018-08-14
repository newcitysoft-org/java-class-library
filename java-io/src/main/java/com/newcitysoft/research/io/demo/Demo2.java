package com.newcitysoft.research.io.demo;

import java.io.File;
import java.util.Arrays;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/8/14 10:23
 */
public class Demo2 {

    public static void main(String[] args) {
        File file = new File("D:\\data\\test");
        deleteFolder(file);
    }

    private static void deleteFolder(File file) {
        File[] files = file.listFiles();

        if(files != null && files.length > 0) {
            Arrays.stream(files).forEach(f -> {
                if(f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    System.out.println(String.format("文件（%s），被删除：%s", f.getName(), String.valueOf(f.delete())));
                }
            });
        }

        System.out.println(String.format("文件夹（%s），被删除：%s", file.getName(), String.valueOf(file.delete())));
    }
}
