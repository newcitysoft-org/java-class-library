package com.newcitysoft.research.io.demo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/8/27 10:32
 */
public class PropertiesDemo {

    public static void main(String[] args) throws IOException {
//        load();
        store();
    }

    private static final void load() throws IOException {
        Properties properties = new Properties();

        FileReader fileReader = new FileReader("config.properties");
        properties.load(fileReader);
        fileReader.close();

        Set<String> keySet = properties.stringPropertyNames();

        keySet.forEach(key-> {
            String property = properties.getProperty(key);

            System.out.println(key + ":" + property);
        });
    }

    private static final void store() throws IOException {
        Properties properties = new Properties();

        properties.setProperty("corePoolSize", String.valueOf(10));
        properties.setProperty("maxPoolSize", String.valueOf(20));

        FileWriter writer = new FileWriter("config2.properties");

        properties.store(writer, "项目置信息");

        writer.close();
    }
}
