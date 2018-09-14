package com.newcitysoft.research.java.net.tcp.demo4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/14 11:13
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("10.2.52.175", 10010);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String line = null;
        while ((line = reader.readLine()) != null) {
            if("over".equals(line)) {
                break;
            }

            writer.write(line);
            writer.newLine();
            writer.flush();
        }

        socket.close();
    }
}
