package com.newcitysoft.research.java.net.tcp.demo3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/14 11:03
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("10.2.52.175", 10086);

        BufferedReader br = new BufferedReader(new FileReader("config2.properties"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String line = null;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        br.close();
        socket.close();
    }
}
