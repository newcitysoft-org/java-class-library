package com.newcitysoft.research.java.net.tcp.demo6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/14 11:37
 */
public class Client {

    public static void main(String[] args) throws IOException {
        // 创建客户端Socket对象
        Socket socket = new Socket("10.2.52.175", 10086);
        // 创建文件输入路
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\tianlixin\\idea-workspace\\newcitysoft\\research\\java\\java-class-library\\java-net\\src\\main\\java\\com\\newcitysoft\\research\\java\\net\\tcp\\demo5\\Server.java"));
        // 获取通道输出路
        BufferedOutputStream bw = new BufferedOutputStream(socket.getOutputStream());
        // 从文件读取数据写入通道内
        byte[] bytes = new byte[1024];
        int length = 0;
        while ((length = bis.read(bytes)) != -1) {
            bw.write(bytes, 0, length);
            bw.flush();
        }
        // 关闭通道输出流
        socket.shutdownOutput();
        // 获取服务端响应数据
        InputStream is = socket.getInputStream();
        byte[] bytes2 = new byte[1024];
        int length2 = 0;
        while ((length2 = is.read(bytes2)) != -1) {
            System.out.println(new String(bytes2, 0, length2));
        }

        bis.close();
        socket.close();
    }
}
