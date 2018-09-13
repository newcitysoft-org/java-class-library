package com.newcitysoft.research.java.net.tcp.demo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/13 10:44
 */
public class Server {

    public static void main(String[] args) throws IOException {
        // 创建服务端Socket对象
        ServerSocket serverSocket = new ServerSocket(10086);
        // 获取连接Socket对象
        Socket socket = serverSocket.accept();
        // 获取ip地址
        String ip = socket.getInetAddress().getHostAddress();
        // 获取输入流
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        // 读取数据并控制台输出
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(ip.concat(":").concat(line));
        }
        // 释放资源
        socket.close();
    }
}
