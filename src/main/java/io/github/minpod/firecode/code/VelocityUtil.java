package io.github.minpod.firecode.code;

import io.github.minpod.firecode.database.Table;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


/**
 * Created by mingle.
 * Time 2017/10/21 下午1:54
 * Desc 文件描述
 */
public class VelocityUtil {
    
    public static String make(String author, String base, String module, Table table, String tpl) {
        // 初始化模板引擎
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        Properties prop = new Properties();
        prop.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
        prop.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
        prop.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
        ve.init(prop);
        // 获取模板文件
        Template t = ve.getTemplate(tpl);
        // 设置变量
        Date now = new Date();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String time = fmt.format(now);
        VelocityContext ctx = new VelocityContext();
        ctx.put("author", author);
        ctx.put("time", time);
        ctx.put("table", table);
        ctx.put("base", base);
        ctx.put("module", module);
        ctx.put("tableName", table.getTableName());
        ctx.put("clazzName", table.getClazzName());
        ctx.put("javaName", table.getJavaName());
        ctx.put("columnMap", table.getColumnMap());
        // 输出
        StringWriter sw = new StringWriter();
        t.merge(ctx, sw);
        return sw.toString();
    }
}
