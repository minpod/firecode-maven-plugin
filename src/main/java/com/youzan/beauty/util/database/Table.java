package com.youzan.beauty.util.database;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by mingle.
 * Time 2017/10/21 下午1:17
 * Desc 文件描述
 */
public class Table {
    
    private String tableName;
    
    private String clazzName;
    
    private String javaName;
    
    private Map<String, Column> columnMap = new LinkedHashMap<>();
    
    
    public String getClazzName() {
        return clazzName;
    }
    
    
    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }
    
    
    public Map<String, Column> getColumnMap() {
        return columnMap;
    }
    
    
    public void setColumnMap(Map<String, Column> columnMap) {
        this.columnMap = columnMap;
    }
    
    
    public String getJavaName() {
        return javaName;
    }
    
    
    public void setJavaName(String javaName) {
        this.javaName = javaName;
    }
    
    
    public String getTableName() {
        return tableName;
    }
    
    
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
