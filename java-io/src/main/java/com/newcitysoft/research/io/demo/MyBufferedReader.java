package com.newcitysoft.research.io.demo;

import java.io.IOException;
import java.io.Reader;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/8/24 15:12
 */
public class MyBufferedReader {

    private Reader reader;

    public MyBufferedReader(Reader reader) {
        this.reader = reader;
    }

    public String readLine() throws IOException {
        StringBuilder sb = new StringBuilder();

        int ch = 0;
        while ((ch = this.reader.read()) != -1) {
            if(ch == '\r') {
                continue;
            }

            if(ch == '\n') {
                return sb.toString();
            } else {
                sb.append((char) ch);
            }
        }

        if(!sb.toString().equals("")) {
            return sb.toString();
        }

        return null;
    }
}
