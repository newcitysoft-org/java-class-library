package com.newcitysoft.research.java.classlibrary.reflect.demo3;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/18 10:33
 */
public class DemoTest {

    public static void main(String[] args) throws Exception {
        Student student = new Student();

        PropertyUtil.setVale(student, "age", 26);
        PropertyUtil.setVale(student, "name", "tianlixin");
        PropertyUtil.setVale(student, "code", "120402033");

        System.out.println(student);

        System.out.println("----------------");

        Dog dog = new Dog();

        PropertyUtil.setVale(dog, "sex", '公');
        PropertyUtil.setVale(dog, "weight", 10.56f);

        System.out.println(dog);
    }
}
