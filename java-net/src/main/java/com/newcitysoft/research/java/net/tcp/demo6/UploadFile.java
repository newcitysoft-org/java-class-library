package com.newcitysoft.research.java.net.tcp.demo6;

import java.io.Serializable;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/14 15:41
 */
public class UploadFile implements Serializable {

    private static final long serialVersionUID = 5018568927563338764L;

    private String fileName;
    private int length;
    private byte[] entity;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte[] getEntity() {
        return entity;
    }

    public void setEntity(byte[] entity) {
        this.entity = entity;
    }
}
