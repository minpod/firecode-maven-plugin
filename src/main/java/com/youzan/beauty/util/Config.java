package com.youzan.beauty.util;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * Created by mingle.
 * Time 2017/10/30 上午12:58
 * Desc 文件描述
 */
@XmlRootElement
public class Config {
    
    private String author;  //开发者名称
    
    private String basePackage; //项目级别packae
    
    private String module;  //模块名称
    
    private String database;    //数据库连接
    
    private String user;    //数据库用户名
    
    private String password;    //数据库密码
    
    private String table;   //表名称
    
    private String clazzName; //类名
    
    private String javaName;    //字段名
    
    private Boolean dal = true;    //是否生成dal层代码
    
    private Boolean req = true;    //是否生成请求对象
    
    private Boolean resp = true;    //是否生成返回对象
    
    private Boolean manager = true;     //manager层
    
    private Boolean service = true;     //manager层
    
    private Boolean transutil = true;    //是否生成transutil代码
    
    
    public String getAuthor() {
        return author;
    }
    
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    
    public String getBasePackage() {
        return basePackage;
    }
    
    
    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }
    
    
    public Boolean getDal() {
        return dal;
    }
    
    
    public void setDal(Boolean dal) {
        this.dal = dal;
    }
    
    
    public String getDatabase() {
        return database;
    }
    
    
    public void setDatabase(String database) {
        this.database = database;
    }
    
    
    
    public Boolean getManager() {
        return manager;
    }
    
    
    public void setManager(Boolean manager) {
        this.manager = manager;
    }
    
    
    public Boolean getService() {
        return service;
    }
    
    
    public void setService(Boolean service) {
        this.service = service;
    }
    
    
    public String getModule() {
        return module;
    }
    
    
    public void setModule(String module) {
        this.module = module;
    }
    
    
    
    
    
    public String getPassword() {
        return password;
    }
    
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public Boolean getReq() {
        return req;
    }
    
    
    public void setReq(Boolean req) {
        this.req = req;
    }
    
    
    public Boolean getResp() {
        return resp;
    }
    
    
    public void setResp(Boolean resp) {
        this.resp = resp;
    }
    
    
    public String getTable() {
        return table;
    }
    
    
    public void setTable(String table) {
        this.table = table;
    }
    
    
    public String getJavaName() {
        return javaName;
    }
    
    
    public void setJavaName(String javaName) {
        this.javaName = javaName;
    }
    
    
    public Boolean getTransutil() {
        return transutil;
    }
    
    
    public void setTransutil(Boolean transutil) {
        this.transutil = transutil;
    }
    
    
    public String getUser() {
        return user;
    }
    
    
    public void setUser(String user) {
        this.user = user;
    }
    
    
    public String getClazzName() {
        return clazzName;
    }
    
    
    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }
    
    
    @Override
    public String toString() {
        return "Config{" + "author='" + author + '\'' + ", basePackage='" + basePackage + '\'' + ", module='" + module + '\'' + ", database='" + database + '\'' + ", user='" + user + '\'' + ", " +
                "password='" + password + '\'' + ", table='" + table + '\'' + ", clazzName='" + clazzName + '\'' + ", javaName='" + javaName + '\'' + ", dal=" + dal + ", req=" + req + ", resp=" +
                resp + ", manager=" + manager + ", service=" + service + ", transutil=" + transutil + '}';
    }
}
