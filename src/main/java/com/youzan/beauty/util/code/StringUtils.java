package com.youzan.beauty.util.code;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by mingle.
 * Time 2017/10/21 下午2:25
 * Desc 文件描述
 */
public class StringUtils {
    
    public static String tran2ClazzName(String columnName) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] splitAry = columnName.split("_");
        for (String split : splitAry) {
            stringBuffer.append(upperFirstChar(split));
        }
        return stringBuffer.toString();
    }
    
    
    private static String upperFirstChar(String str) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str.toCharArray().length; i++) {
            char c = str.toCharArray()[i];
            if (i == 0) {
                list.add(Character.toUpperCase(c));
            }else {
                list.add(c);
            }
        }
        char[] chars = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            chars[i] = list.get(i);
        }
        return new String(chars);
        
    }
    
    
    public static String tran2JavaName(String columnName) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] splitAry = columnName.split("_");
        for (int i = 0; i < splitAry.length; i++) {
            String split = splitAry[i];
            if (i != 0) {
                stringBuffer.append(upperFirstChar(split));
            }else {
                stringBuffer.append(split);
            }
        }
        return stringBuffer.toString();
    }
}
