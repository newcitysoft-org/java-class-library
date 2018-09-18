package com.newcitysoft.research.java.classlibrary.reflect.demo3;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/18 10:32
 */
public class Student {
    private String name;
    public String code;
    public int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", age=" + age +
                '}';
    }
}
