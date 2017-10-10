package com.skyfree.maven.common.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class GyUtils {
    
    public static <K, V> Map<K, V> sortMap(Map<K, V> map, Comparator<Entry<K, V>> comparator) {
        if(map == null || map.size() == 0 || comparator == null) {
            return map;
        }
        
        //转成数组排序
        List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (Entry<K, V> k1, Entry<K, V> k2) -> comparator.compare(k1, k2));
        
        //转回linkedMap，通过插入顺序保证map顺序
        Map<K, V> retMap = new LinkedHashMap<>();
        for(Entry<K, V> entry : list) {
            retMap.put(entry.getKey(), entry.getValue());
        }
        return retMap;
    }
    
    
    /**
     * @description is Null for object
     * @time 2015-12-16下午09:38:00
     * @param object
     * @return
     * @author   nilu
     */
    public static boolean isNull(Object object) {
        boolean flag = true;
        if(null != object) {
            if(object instanceof Object[]) {
                flag = isNull((Object[])object);
            } else if(object instanceof String) {
                flag = isNull((String)object);
            } else if(object instanceof List<?>) {
                flag = isNull((List<?>)object);
            } else if(object instanceof Map<?,?>) {
                flag = isNull((Map<?,?>)object);
            } else if(object instanceof Set<?>) {
                flag = isNull((Set<?>)object);
            } else if(object instanceof JSONObject) {
                flag = isNull(object);
            } else if(object instanceof JSONArray) {
                flag = isNull(object);
            } else{
                flag = false;
            }
        }
        return flag;
    }
    
    /**
     * @description is Null for object[]
     * @time 2015-12-16下午09:36:51
     * @param objects
     * @return
     * @author   nilu
     */
    public static boolean isNull(Object[] objects) {
        return null == objects || 0 == objects.length;
    }
    
    /**
     * @description is Null for string
     * @time 2015-12-16下午09:37:07
     * @param string
     * @return
     * @author   nilu
     */
    public static boolean isNull(String string) {
        return null == string || "".equals(string);
    }
    
    /**
     * @description is Null for List
     * @time 2015-12-16下午09:37:17
     * @param list
     * @return
     * @author   nilu
     */
    public static boolean isNull(List<?> list) {
        return null == list || list.isEmpty();
    } 
    
    /**
     * @description is Null for map
     * @time 2015-12-16下午09:37:34
     * @param map
     * @return
     * @author   nilu
     */
    public static boolean isNull(Map<?,?> map) {
        return null == map || map.isEmpty();
    }
    
    /**
     * @description is Null for set
     * @time 2015-12-16下午09:37:43
     * @param set
     * @return
     * @author   nilu
     */
    public static boolean isNull(Set<?> set) {
        return null == set || set.isEmpty();
    }
    
    /**
     * @description is Null for JSONObject
     * @time 2015-12-16下午09:37:43
     * @param obj
     * @return
     * @author   nilu
     */
    public static boolean isNull(JSONObject obj) {
        return null == obj || obj.isEmpty();
    }
    
    /**
     * @description is Null for JSONArray
     * @time 2015-12-16下午09:37:43
     * @param obj
     * @return
     * @author   nilu
     */
    public static boolean isNull(JSONArray obj) {
        return null == obj || obj.isEmpty();
    }
}
