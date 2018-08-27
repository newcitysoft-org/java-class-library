package com.newcitysoft.research.io.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * IDEA自动生成序列化ID，详看：http://note.youdao.com/noteshare?id=1f43afea669d5de090fbb7227d8816a5&sub=E5DC4ABD17504BE8873ADB22DFD6C1C4
 *
 * @author lixin.tian@renren-inc.com
 * @date 2018/8/27 10:43
 */
public class ObjectStreamDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        write();
        read();
    }

    private static final void read() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.txt"));

//        while (ois.available() != 0) {
        int available = ois.available();
        System.out.println(available);
        Object o = ois.readObject();
        System.out.println(o);


        available = ois.available();
        System.out.println(available);
        o = ois.readObject();
        System.out.println(o);

        available = ois.available();
        System.out.println(available);
//        }

    }

    private static final void write() throws IOException {
        Person person = Person.builder().name("田利新").gender(Person.Gender.MALE).age(26).build();
        Person person2 = Person.builder().name("肖寰").gender(Person.Gender.FEMALE).age(25).build();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"));

        oos.writeObject(person);
        oos.writeObject(person2);

        oos.close();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class Person implements Serializable {
        private static final long serialVersionUID = -998667245623775749L;
        private String name;
        private Gender gender;
        private int age;

        public enum Gender {
            MALE,
            FEMALE
        }
    }
}
