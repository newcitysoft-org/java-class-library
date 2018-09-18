package com.newcitysoft.research.java.classlibrary.reflect.demo3;

import java.lang.reflect.Field;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/9/18 10:29
 */
public class PropertyUtil {

    public static final void setVale(Object obj, String prop, Object value) throws Exception {
        Class<?> clazz = obj.getClass();

        Field field = clazz.getDeclaredField(prop);
        field.setAccessible(true);

        field.set(obj, value);
    }

}
