package com.newcitysoft.research.java.net.tcp.demo6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/14 15:29
 */
public class UploadRunnable implements Runnable {

    private Socket socket;

    public UploadRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 获取通道的输入流
            BufferedInputStream br = new BufferedInputStream(socket.getInputStream());
            // 创建输出流
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("YmlConfig-2.java"));
            // 读取数据
            byte[] bytes = new byte[1024];
            int length = 0;
            while((length = br.read(bytes)) != -1) {
                bos.write(bytes, 0, length);
                bos.flush();
            }

            OutputStream os = socket.getOutputStream();
            os.write("数据接收完毕".getBytes());
            os.flush();

            bos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
