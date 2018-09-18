package com.newcitysoft.research.java.classlibrary.reflect;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/17 17:27
 */
public class Student {
    public String name;
    private String code;
    public int age;

    public Student() {

    }

    private Student(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Student(String name, String code, int age) {
        this.name = name;
        this.code = code;
        this.age = age;
    }

    public void set(String name, String code) {
        this.name = name;
        this.code = code;
    }

    private void set(String name, String code, int age) {
        this.name = name;
        this.code = code;
        this.age = age;
    }
}
