package com.newcitysoft.research.java.net.tcp.demo5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
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
        BufferedReader br = new BufferedReader(new FileReader("YmlConfig.java"));
        // 获取通道输出路
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        // 从文件读取数据写入通道内
        String line = null;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        // 关闭通道输出流
        socket.shutdownOutput();
        // 获取服务端响应数据
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int length = 0;
        while ((length = is.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, length));
        }

        br.close();
        socket.close();
    }
}
