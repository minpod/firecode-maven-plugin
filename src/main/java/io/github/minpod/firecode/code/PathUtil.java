package io.github.minpod.firecode.code;

import java.io.File;


/**
 * Created by mingle.
 * Time 2017/10/21 下午9:24
 * Desc 文件描述
 */
public class PathUtil {
    
    public static String getJavaPath() {
        return getSrcPath() + File.separator + "java";
    }
    
    
    public static String getSrcPath() {
        return getProjectPath() + File.separator + "src" + File.separator + "main";
    }
    
    public static String getTestPath() {
        return getProjectPath() + File.separator + "src" + File.separator + "test" + File.separator + "java";
    }
    
    
    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }
    
    
    public static String getResourcesPath() {
        return getSrcPath() + File.separator + "resources";
    }
    
    
    public static void main(String[] args) {
        System.out.println(getProjectPath());
        System.out.println(getSrcPath());
    }
}
