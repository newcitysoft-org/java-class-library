package com.newcitysoft.research.java.net.tcp.demo5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
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
        Socket socket = serverSocket.accept();
        // 获取通道的输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // 创建输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("YmlConfig-2.java"));
        // 读取数据
        String line = null;
        while((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        OutputStream os = socket.getOutputStream();
        os.write("数据接收完毕".getBytes());
        os.flush();

        bw.close();
        socket.close();
    }
}
