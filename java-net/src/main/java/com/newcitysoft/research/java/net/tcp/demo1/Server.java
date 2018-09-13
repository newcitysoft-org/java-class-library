package com.newcitysoft.research.java.net.tcp.demo1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/13 10:32
 */
public class Server {

    public static void main(String[] args) throws IOException {
        // 创建服务端TCP套接字
        ServerSocket serverSocket = new ServerSocket(10086);
        // 接收客户端传来的Socket
        Socket accept = serverSocket.accept();
        // 获取输入流
        InputStream inputStream = accept.getInputStream();
        byte[] bytes = new byte[1024];
        int length = 0;
        while ((length = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, length));
        }
        // 释放资源
        accept.close();
    }
}
