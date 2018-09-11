package com.newcitysoft.research.java.net.udp.demo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/11 13:52
 */
public class UdpSender {

    public static void main(String[] args) throws IOException {
        // 创建Socket对象
        DatagramSocket socket = new DatagramSocket();
        // 准备数据
        byte[] bys = "hello".getBytes();
        InetAddress address = InetAddress.getByName("10.2.52.175");
        int port = 12345;
        // 创建数据包对象
        DatagramPacket packet = new DatagramPacket(bys, bys.length, address, port);
        // 发送数据
        socket.send(packet);
        // 关闭会话资源
        socket.close();
    }
}
