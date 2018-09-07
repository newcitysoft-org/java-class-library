package com.newcitysoft.research.java.classlibrary.thread.simple2;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/4 10:29
 */
public class Student {
    private String name;
    private int age;
    private boolean flag;

    public Student() {
    }

    public Student(String name, int age, boolean flag) {
        this.name = name;
        this.age = age;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", flag=" + flag +
                '}';
    }
}
