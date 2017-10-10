package com.skyfree.maven.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EntityUtil {

    /**
     *@description 实体属性值合并
     *@time 创建时间:2017年9月25日下午3:49:38
     *@param entity 数据库中的实体对象
     *@param parameter 参数中的实体对象
     *@author dzn
     */
    public static <T> void merge(T entity, T parameter) {
        if(null == entity){
            return;
        }
        Field[] fields = parameter.getClass().getDeclaredFields();
        Object value = null;
        String methodName = null;
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                value = field.get(parameter);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (value != null) {
                methodName = "set" + firstToUpperCase(field.getName());
                try {
                    Method declaredMethod = entity.getClass().getDeclaredMethod(methodName, value.getClass());
                    declaredMethod.invoke(entity, value);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (SecurityException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    private static String firstToUpperCase(String str) {
        char[] cs = str.toCharArray();
        cs[0] -= 32;
        return new String(cs);
    }
}
