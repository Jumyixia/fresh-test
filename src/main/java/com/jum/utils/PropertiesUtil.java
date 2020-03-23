package com.jum.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtil {
    public PropertiesUtil() {
    }

    public static String readPropertyValue(String fileName, String key) throws IOException {
        Properties props = new Properties();
        InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);
        props.load(in);
        String value = props.getProperty(key);
        return value;
    }

    /*基于ClassLoder读取配置文件, 该方式只能读取类路径下的配置文件，有局限但是如果配置文件在类路径下比较方便。*/
    public static Map<String, String> readProperties(String fileName) throws IOException {
        Map<String, String> properties = new HashMap();
        Properties props = new Properties();
        // 使用ClassLoader加载properties配置文件生成对应的输入流
        InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);
        // 使用properties对象加载输入流
        props.load(in);
        Enumeration en = props.propertyNames();

        while(en.hasMoreElements()) {
            String key = (String)en.nextElement();
            //获取key对应的value值
            String property = props.getProperty(key);
            properties.put(key, property);
        }

        return properties;
    }
}