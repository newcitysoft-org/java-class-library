package com.newcitysoft.research.java.net.tcp.demo7;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
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
        // 获取通道输出流
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        // 写文件名
        dos.writeUTF("city.csv");
        // 写文件
        BufferedInputStream bis  = new BufferedInputStream(new FileInputStream("D:\\data\\city.csv"));
        byte[] bytes = new byte[1024];
        int length = 0;
        while ((length = bis.read(bytes)) != -1) {
            dos.write(bytes, 0, length);
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

        socket.close();
    }
}
