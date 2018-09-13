package com.newcitysoft.research.java.net.tcp.demo1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/13 10:38
 */
public class Client {

    public static void main(String[] args) throws IOException {
        // 创建客户端Socket对象
        Socket socket = new Socket("10.2.52.175", 10086);
        // 获取输出流对象
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello java tcp".getBytes());
        // 释放资源
        outputStream.close();
        socket.close();
    }
}
