package com.newcitysoft.research.java.net.udp.demo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/11 14:07
 */
public class UdpReceiver {

    public static void main(String[] args) throws IOException {
        int port = 12345;
        // 创建接收端Socket对象
        DatagramSocket socket = new DatagramSocket(port);
        byte[] bys = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bys, bys.length);
        while (true) {
            socket.receive(packet);
            String data = new String(bys, 0, packet.getLength());
            String ip = packet.getAddress().getHostAddress();
            if("886".equals(data)) {
                break;
            } else {
                System.out.println(ip.concat(":").concat(data));
            }
        }

        System.out.println("停止接收");
        socket.close();
    }
}
