package com.newcitysoft.research.java.net.tcp.demo7;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端接收数据存到文本文件
 *
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/14 11:29
 */
public class Server {

    public static void main(String[] args) throws IOException {
        // 创建ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(10086);
        // 获取会话Socket对象
        Socket socket = null;
        while ((socket = serverSocket.accept()) != null) {
            new Thread(new UploadRunnable(socket)).start();
        }
    }
}
