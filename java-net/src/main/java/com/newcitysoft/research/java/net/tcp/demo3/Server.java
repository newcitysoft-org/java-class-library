package com.newcitysoft.research.java.net.tcp.demo3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/14 11:04
 */
public class Server {

    public static void main(String[] args)  throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);
        Socket socket = serverSocket.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        socket.close();
    }
}
