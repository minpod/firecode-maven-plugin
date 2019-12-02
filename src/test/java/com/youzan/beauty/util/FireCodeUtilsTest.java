package com.youzan.beauty.util;

import io.github.minpod.firecode.FireCodeUtils;
import io.github.minpod.firecode.database.MetaUtil;
import io.github.minpod.firecode.database.Table;

import org.junit.Test;


/**
 * Created by mingle.
 * Time 2017/11/7 下午8:26
 * Desc 文件描述
 */
public class FireCodeUtilsTest {
    
    private static Table table = MetaUtil.getMeta("jdbc:mysql://127.0.0.1:3306/dsp?useSSL=false", "root", "mingle", "ad_idea", "AdIdea", "adIdea");
    
    private static String basePackage = "com.youzan.mei.demo";
    
    private static String module = "hello";
    
    private static String author = "mingle";
    
    @Test
    public void makeSql() throws Exception {
        String file = FireCodeUtils.makeSql(table, author, module, basePackage);
        System.out.println(file);
    }
    
    @Test
    public void makeDOTest() {
        String file = FireCodeUtils.makeDO(table, author, module, basePackage, "");
        System.out.println(file);
    }
    
    @Test
    public void makeManager() throws Exception {
        String file = FireCodeUtils.makeManager(table, author, module, basePackage, basePackage.replaceAll("\\.", "/"));
        System.out.println(file);
    }
    
    @Test
    public void makeTest() {
        String file = FireCodeUtils.makeTest(table, author, module, basePackage, basePackage.replaceAll("\\.", "/"));
        System.out.println(file);
    }
    
    @Test
    public void makeService() {
        String file = FireCodeUtils.makeService(table, author, module, basePackage, basePackage.replaceAll("\\.", "/"));
        System.out.println(file);
    }
    
    @Test
    public void makeServiceImpl() {
        String file = FireCodeUtils.makeServiceImpl(table, author, module, basePackage, basePackage.replaceAll("\\.", "/"));
        System.out.println(file);
    }
    
    @Test
    public void makeServiceTest() {
        String file = FireCodeUtils.makeServiceTest(table, author, module, basePackage, basePackage.replaceAll("\\.", "/"));
        System.out.println(file);
    }
    
    @Test
    public void makeCreateTest() {
        String file = FireCodeUtils.makeCreate(table, author, module, basePackage, basePackage.replaceAll("\\.", "/"));
        System.out.println(file);
    }
    
    @Test
    public void makeUpdateTest() {
        String file = FireCodeUtils.makeUpdate(table, author, module, basePackage, basePackage.replaceAll("\\.", "/"));
        System.out.println(file);
    }
    
    @Test
    public void makeRespTest() {
        String file = FireCodeUtils.makeResp(table, author, module, basePackage, basePackage.replaceAll("\\.", "/"));
        System.out.println(file);
    }
}
