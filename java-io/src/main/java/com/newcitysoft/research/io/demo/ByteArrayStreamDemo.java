package com.newcitysoft.research.io.demo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayStreamDemo {

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        for(int i = 0; i < 10; i++) {
            bos.write(("hello" + i + "\r\n").getBytes());
        }

        byte[] bytes = bos.toByteArray();

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);

        int ch = 0;
        while((ch = bis.read()) != -1) {
            System.out.print((char) ch);
        }
    }
}
