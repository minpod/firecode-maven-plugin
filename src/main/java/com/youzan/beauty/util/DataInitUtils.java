package com.youzan.beauty.util;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


/**
 * Created by mingle.
 * Time 2017/8/15 下午3:04
 * Desc 文件描述
 */
public class DataInitUtils {
    
    public static void initObj(Object object) {
        setField(object, object.getClass());
    }
    
    private static void setField(Object object, Class clazz) {
        if (Object.class.equals(clazz)) {
            return;
        }
        try {
            Random random = new Random();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSSS");
            String timeStr = sdf.format(new Date());
            Date now = sdf.parse(timeStr);
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                if (f.getName().equals("serialVersionUID)")) {
                    continue;
                }
                if (f.getType().equals(Long.class)) {
                    f.setAccessible(true);
                    f.set(object, Math.abs(random.nextLong() % 100000L));
                }else if (f.getType().equals(Integer.class)) {
                    f.setAccessible(true);
                    f.set(object, Math.abs(random.nextInt(10)));
                }else if (f.getType().equals(Double.class)) {
                    f.setAccessible(true);
                    f.set(object, Math.abs(random.nextDouble()));
                }else if (f.getType().equals(Float.class)) {
                    f.setAccessible(true);
                    f.set(object, Math.abs(random.nextFloat()));
                }else if (f.getType().equals(String.class)) {
                    f.setAccessible(true);
                    f.set(object, "测试" + "(" + timeStr + ")");
                }else if (f.getType().equals(Date.class)) {
                    f.setAccessible(true);
                    f.set(object, now);
                }
            }
            //递归
            setField(object, clazz.getSuperclass());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    //@Test
    public static void setget(String setName, String getName, Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            String name = f.getName();
            String upName = name.substring(0, 1).toUpperCase() + name.substring(1);
            System.out.println(setName + ".set" + upName + "(" + getName + ".get" + upName + "()" + ");");
        }
    }
    
    
    /*public void sql() {
        char underline = '_';
        Field[] fields = UserMemberCardDO.class.getDeclaredFields();
        for (Field f : fields) {
            String name = f.getName();
            StringBuffer stringBuffer = new StringBuffer();
            Query<Character> list = new ArrayList<>();
            for (int i = 0; i < name.toCharArray().length; i++) {
                char c = name.toCharArray()[i];
                if (Character.isUpperCase(c)) {
                    list.add(underline);
                    list.add(Character.toLowerCase(c));
                }else {
                    list.add(c);
                }
            }
            char[] chars = new char[list.size()];
            for (int i = 0; i < list.size(); i++) {
                chars[i] = list.get(i);
            }
            name = new String(chars);
            System.out.println("`" + name + "`,");
        }
        for (Field f : fields) {
            String name = f.getName();
            System.out.println("#{" + name + "},");
        }
    }*/
    
}
