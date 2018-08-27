package com.newcitysoft.research.io.demo;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

    public static void main(String[] args) throws IOException {
//        write();
        read();
    }

    private static final void read() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("raf.txt", "rw");

        int i = raf.readInt();
        System.out.println(i + ":" + raf.getFilePointer());
        char c = raf.readChar();
        System.out.println(c + ":" + raf.getFilePointer());
        String s = raf.readUTF();
        System.out.println(s + ":" + raf.getFilePointer());

        raf.close();
    }

    private static final void write() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("raf.txt", "rw");

        raf.writeInt(100);
        raf.writeChar('a');
        raf.writeUTF("中国");

        raf.close();
    }
}
