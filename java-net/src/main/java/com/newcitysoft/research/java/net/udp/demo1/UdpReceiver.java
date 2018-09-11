package com.newcitysoft.research.java.net.udp.demo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/11 13:51
 */
public class UdpReceiver {

    public static void main(String[] args) throws IOException {
        int port = 12345;
        // 创建Socket对象
        DatagramSocket socket = new DatagramSocket(port);
        // 创建接收的容器
        byte[] bys = new byte[1024];
        // 创建接收的数据包
        DatagramPacket packet = new DatagramPacket(bys, bys.length);
        // 接收数据
        socket.receive(packet);
        // 打印数据
        String data = new String(bys, 0, packet.getLength());
        String ip = packet.getAddress().getHostAddress();
        System.out.println(ip + ":" + data);
        // 关闭数据源
        socket.close();
    }
}
