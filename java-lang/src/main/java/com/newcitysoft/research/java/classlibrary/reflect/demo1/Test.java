package com.newcitysoft.research.java.classlibrary.reflect.demo1;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/18 10:10
 */
public class Test {

    public static void main(String[] args) throws Exception {
        // 创建Properties对象
        Properties properties = new Properties();
        FileReader fr = new FileReader("config.txt");
        // 加载外部配置文件的键值对
        properties.load(fr);
        // 读取属性
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");
        // 获取配置文件中指定的字节码文件对象
        Class clazz = Class.forName(className);
        // 创建实例
        Object obj = clazz.newInstance();
        // 根据方法名称获取方法
        Method method = clazz.getMethod(methodName);
        // 调用方法
        method.invoke(obj);
    }
}
