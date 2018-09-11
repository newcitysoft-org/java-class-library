package com.newcitysoft.research.java.net.udp.demo3;

import java.io.IOException;
import java.net.DatagramSocket;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/11 14:26
 */
public class ChatDemo {

    public static void main(String[] args) throws IOException {
        DatagramSocket sender = new DatagramSocket();
        DatagramSocket receiver = new DatagramSocket(12345);

        Runnable sr = new SenderRunnable(sender);
        Runnable rr = new ReceiverRunnable(receiver);

        Thread t1 = new Thread(sr);
        Thread t2 = new Thread(rr);

        t1.start();
        t2.start();
    }
}
