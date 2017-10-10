package com.skyfree.maven.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtils {
    
    /**
     * @description 根据路径读取配置文件
     * @time 创建时间:2017年10月9日下午8:12:57
     * @param path
     * @return
     * @throws IOException
     * @author 倪路
     */
    public static Properties readProperteis(String path) throws IOException {
        Properties properties = new Properties();
        InputStream in = PropertiesUtils.class.getResourceAsStream("/" + path);
        properties.load(in);
        return properties;
    }
    
    /**
     * @description 根据前缀解析得到相同前缀的所有配置
     * @time 创建时间:2017年10月9日下午8:13:09
     * @param props
     * @param prefix
     * @return
     * @author 倪路
     */
    public static Map<String, String> readPropsByPrefix(Properties props, String prefix) {
        Map<String, String> result = new HashMap<>();
        for (Enumeration<?> e = props.propertyNames(); e.hasMoreElements();) {
            String key = (String) e.nextElement();
            if (key.startsWith(prefix)) {
                result.put(key.substring(prefix.length() + 1), props.getProperty(key));
            }
        }
        return result;
    }
}
