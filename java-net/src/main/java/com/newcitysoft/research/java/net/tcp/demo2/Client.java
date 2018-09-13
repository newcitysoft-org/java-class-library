package com.newcitysoft.research.java.net.tcp.demo2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/13 10:44
 */
public class Client {

    public static void main(String[] args) throws IOException {
        // 创建对象
        Socket socket = new Socket("10.2.52.175", 10086);
        // 创建键盘输入流独享
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 获取输出流
        OutputStream os = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        // 键盘录入并输出到Socket通道
        String line = null;
        while ((line = br.readLine()) != null) {
            if("886".equals(line)) {
                break;
            }

            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        // 释放资源
        socket.close();
    }
}
