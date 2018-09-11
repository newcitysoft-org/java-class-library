package com.newcitysoft.research.java.net.udp.demo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/11 14:27
 */
public class ReceiverRunnable implements Runnable {

    private DatagramSocket socket;

    public ReceiverRunnable(DatagramSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
