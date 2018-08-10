package com.newcitysoft.research.io.demo;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/8/10 10:11
 */
public class Demo1 {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\data");
        File childFile = new File(file, "color.txt");
        // 判断方法
        System.out.println("文件是否存在：" + childFile.exists());
        System.out.println("文件是否可读：" + childFile.canRead());
        System.out.println("文件是否可写：" + childFile.canWrite());
        System.out.println("文件是否为绝对路径：" + childFile.isAbsolute());
        System.out.println("文件是否为目录："+ childFile.isDirectory());
        System.out.println("文件是否为文件：" + childFile.isFile());
        System.out.println("文件是否可执行（???）：" + childFile.canExecute());
        // 获取方法
        System.out.println("获取文件的绝对路径：" + childFile.getAbsolutePath());
        System.out.println("获取文件的大小（字节数）" + childFile.length());
        System.out.println("获取文件名称：" + childFile.getName());
        System.out.println("获取文件路径：" + childFile.getPath());
        // 创建方法
        File newFile = new File(file, "123.txt");
        if(!newFile.exists()) {
            System.out.println(file.getName() + ":" + newFile.createNewFile());
        } else {
            System.out.println(file.getName() + "已存在！");
        }

        File newFolder = new File(file, "file-test");
        if(!newFolder.exists()) {
            System.out.println(newFolder.getName() + ":" + newFolder.mkdir());
        } else {
            System.out.println(newFolder.getName() + "已存在！");
        }

        File newFolders = new File(file, "file-test\\one\\two");
        if(!newFolders.exists()) {
            System.out.println(newFolders.getName() + ":" + newFolders.mkdirs());
        } else {
            System.out.println(newFolders.getName() + "已存在！");
        }
        //　重命名操作
        File renameFile = new File(file, "456.txt");
        if(newFile.exists()) {
            String name = newFile.getName();
            boolean b = newFile.renameTo(renameFile);
            System.out.println(name.concat("重命名：")
                    .concat(b ? "成功；文件名为：".concat(renameFile.getName()).concat("。"):"失败。"));
        }
        // 删除操作
        String name = renameFile.getName();
        if(renameFile.exists()) {
            boolean delete = renameFile.delete();
            System.out.println(name.concat("删除：").concat(delete ? "成功":"失败").concat("。"));
        }

        String newFoldersName = newFolders.getName();
        if(newFolders.exists()) {
            File parentFile = newFolders.getParentFile();
            String parentFileName = parentFile.getName();
            boolean delete = parentFile.delete();
            if(!delete) {
                System.out.println(newFoldersName.concat(String.format("父级（%s）文件不能直接删除，需先删除子文再删除父文件",
                        parentFileName)));
                System.out.println("开始删除子文件...");
                if(parentFile.isDirectory()) {
                    System.out.println(parentFileName + "是目录");
                    File[] files = parentFile.listFiles();
                    Arrays.stream(files).forEach(_file -> {
                        String _fileName = _file.getName();
                        boolean _delete = _file.delete();
                        System.out.println(String.format("子文件（%s）", _fileName).concat("删除：")
                                .concat(_delete ? "成功" : "失败").concat("。"));
                    });
                }
            }
        }
    }

}
