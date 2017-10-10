package com.skyfree.maven.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 驼峰法-下划线互转
 * 
 * @author cshaper
 * @since 2015.07.04
 * @version 1.0.0
 */
public class NameTransferUtils {


    /**
     * 下划线转驼峰法
     * 
     * @param source 源字符串
     * @param smallCamel 大小驼峰,是否为小驼峰
     * @return 转换后的字符串
     */
    public static String underlineCast2Camel(String source, boolean smallCamel) {
        if (GyUtils.isNull(source)) {
            return source;
        }
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("([A-Za-z\\d]+)(_)?");
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()) {
            String word = matcher.group();
            sb.append(smallCamel && matcher.start() == 0 ? Character.toLowerCase(word.charAt(0))
                    : Character.toUpperCase(word.charAt(0)));
            int index = word.lastIndexOf('_');
            if (index > 0) {
                sb.append(word.substring(1, index).toLowerCase());
            } else {
                sb.append(word.substring(1).toLowerCase());
            }
        }
        return sb.toString();
    }

    /**
     * 驼峰法转下划线
     * @param source 源字符串
     * @return 转换后的字符串
     */
    public static String camelCast2Underline(String source) {
        if (GyUtils.isNull(source)) {
            return source;
        }
        source = String.valueOf(source.charAt(0)).toUpperCase().concat(source.substring(1));
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("[A-Z]([a-z\\d]+)?");
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()) {
            String word = matcher.group();
            sb.append(word.toLowerCase());
            sb.append(matcher.end() == source.length() ? "" : "_");
        }
        return sb.toString();
    }
}
