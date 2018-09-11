package com.newcitysoft.research.java.net.udp.demo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/11 14:26
 */
public class SenderRunnable implements Runnable {

    private DatagramSocket socket;

    public SenderRunnable(DatagramSocket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        try {
            // 创建键盘输入对象
            Scanner scanner = new Scanner(System.in);
            // 指定接收端的ip和端口号
            int port = 12345;
            InetAddress address = InetAddress.getByName("10.2.52.175");
            while (true) {
                String data = scanner.next();

                byte[] bytes = data.getBytes();
                DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, port);
                socket.send(packet);

                if("886".equals(data)) {
                    break;
                }
            }
            System.out.println("结束发送");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
