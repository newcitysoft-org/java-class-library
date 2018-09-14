package com.newcitysoft.research.java.net.tcp.demo4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/14 11:13
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10010);

        Socket accept = serverSocket.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new FileWriter("copy.txt"));

        String line = null;
        while ((line = br.readLine()) !=null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        bw.close();
        accept.close();
    }
}
