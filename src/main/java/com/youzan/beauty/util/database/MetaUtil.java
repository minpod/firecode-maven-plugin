package com.youzan.beauty.util.database;

import com.youzan.beauty.util.code.StringUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;


/**
 * Created by mingle.
 * Time 2017/10/21 下午1:17
 * Desc 文件描述
 */
public class MetaUtil {
    
    public static Table getMeta(String url, String user, String pass, String tableName, String clazzName, String javaName) {
        Table table = new Table();
        try {
            table.setTableName(tableName);
            table.setClazzName(clazzName != null ? clazzName : StringUtils.tran2ClazzName(tableName));
            table.setJavaName(javaName != null ? javaName : StringUtils.tran2JavaName(tableName));
            Map<String, Column> columnMap = table.getColumnMap();
            Connection conn = getConnection(url, user, pass);
            String sql = "select * from " + tableName + " limit 1";
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);
            //字段信息
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData data = rs.getMetaData();
            for (int i = 1; i <= data.getColumnCount(); i++) {
                Column column = new Column();
                column.setColumnName(data.getColumnName(i));
                column.setJavaName(StringUtils.tran2JavaName(column.getColumnName()));
                column.setClazzName(StringUtils.tran2ClazzName(column.getColumnName()));
                String clazz = tranSpecialClazz(data.getColumnClassName(i));
                column.setClazz(clazz);
                column.setNumber(Number.class.isAssignableFrom(Class.forName(clazz)));
                column.setSimpleClazz(clazz.substring(clazz.lastIndexOf(".") + 1));
                columnMap.put(column.getColumnName(), column);
            }
            //字段信息
            rs = stmt.executeQuery("show full columns from " + tableName);
            while (rs.next()) {
                Column column = columnMap.get(rs.getString("Field"));
                column.setComment(rs.getString("Comment"));
                columnMap.put(column.getColumnName(), column);
            }
            //索引信息
            rs = stmt.executeQuery("show index from " + tableName);
            while (rs.next()) {
                Column column = columnMap.get(rs.getString("Column_name"));
                column.setIndex(true);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return table;
    }
    
    
    private static Connection getConnection(String url, String user, String pass) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    
    /**
     * 转换特殊的类
     * BigInteger -> Long
     * Timestamp  -> Date
     *
     * @param clazz
     * @return
     */
    private static String tranSpecialClazz(String clazz) {
        if ("java.math.BigInteger".equals(clazz)) {
            return Long.class.getName();
        }
        if ("java.sql.Timestamp".equals(clazz)) {
            return Date.class.getName();
        }
        return clazz;
    }
    
    
    public static void main(String[] args) throws Exception {
        getMeta("jdbc:mysql://10.9.51.13:3008/beauty?useSSL=false", "user_beauty", "i6SXNjDAByLabCdw8GEu", "user_member_card", "MemberCard", "card");
    }
}
