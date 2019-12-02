package com.youzan.beauty.util.database;

/**
 * Created by mingle.
 * Time 2017/10/21 下午1:17
 * Desc 文件描述
 */
public class Column {
    
    //数据库中的名字
    private String columnName;
    
    //java类的名字
    private String javaName;
    
    //首字母大写的名字
    private String clazzName;
    
    //字段类型
    private String clazz;
    
    //简化类型
    private String simpleClazz;
    
    //数据库中的注释
    private String comment;
    
    //是否索引
    private boolean index;
    
    private boolean number;
    
    
    public String getClazz() {
        return clazz;
    }
    
    
    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
    
    
    public String getColumnName() {
        return columnName;
    }
    
    
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
    
    
    public String getComment() {
        return comment;
    }
    
    
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
    public String getJavaName() {
        return javaName;
    }
    
    
    public void setJavaName(String javaName) {
        this.javaName = javaName;
    }
    
    
    public String getClazzName() {
        return clazzName;
    }
    
    
    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }
    
    
    public String getSimpleClazz() {
        return simpleClazz;
    }
    
    
    public void setSimpleClazz(String simpleClazz) {
        this.simpleClazz = simpleClazz;
    }
    
    
    public void setIndex(boolean index) {
        this.index = index;
    }
    
    
    public boolean isIndex() {
        return index;
    }
    
    
    public boolean isNumber() {
        return number;
    }
    
    
    public void setNumber(boolean number) {
        this.number = number;
    }
}
