package com.youzan.beauty.util;

import com.youzan.beauty.util.database.MetaUtil;
import com.youzan.beauty.util.database.Table;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;


/**
 * Created by mingle.
 * Time 2017/10/30 上午10:16
 * Desc firecode
 */
@Mojo(name = "fire", defaultPhase = LifecyclePhase.GENERATE_SOURCES, requiresDependencyResolution = ResolutionScope.TEST)
public class FireCodeMojo extends AbstractMojo {
    
    @Parameter(property = "firecode.generator.configurationFile", defaultValue = "${project.basedir}/src/main/resources/firecode.xml", required = true)
    private File configurationFile;
    
    
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("firecode starts.");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Config.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Config config = (Config) jaxbUnmarshaller.unmarshal(configurationFile);
            System.out.println(config);
            
            String author = config.getAuthor();
            String basePackage = config.getBasePackage();
            String baseDir = basePackage.replaceAll("\\.", "/");
            String module = config.getModule();
            
            Table table = MetaUtil.getMeta(config.getDatabase(), config.getUser(), config.getPassword(), config.getTable(), config.getClazzName(), config.getJavaName());
            
            //sql
            String sqlFile = FireCodeUtils.makeSql(table, author, module, basePackage);
            getLog().info("create file " + sqlFile);
            //DO
            String doFile = FireCodeUtils.makeDO(table, author, module, basePackage, baseDir);
            getLog().info("create file " + doFile);
            //mapper
            String mapperFile = FireCodeUtils.makeMapper(table, author, module, basePackage, baseDir);
            getLog().info("create file " + mapperFile);
            //test
            String testDalFile = FireCodeUtils.makeTest(table, author, module, basePackage, baseDir);
            getLog().info("create file " + testDalFile);
            
            //tran
            String transFile = FireCodeUtils.makeTransUtils(table, author, module, basePackage, baseDir);
            getLog().info("create file " + transFile);
            
            /*if (config.getDto()) {
                String dtoFile = FireCodeUtils.makeDTO(table, author, module, basePackage, baseDir);
                getLog().info("create file " + dtoFile);
            }
            String queryFile = FireCodeUtils.makeQuery(table, author, module, basePackage, baseDir);
            getLog().info("create file " + queryFile);
            String paramFile = FireCodeUtils.makeParam(table, author, module, basePackage, baseDir);
            getLog().info("create file " + paramFile);*/
            String createFile = FireCodeUtils.makeCreate(table, author, module, basePackage, baseDir);
            getLog().info("create file " + createFile);
    
            String updateFile = FireCodeUtils.makeUpdate(table, author, module, basePackage, baseDir);
            getLog().info("create file " + updateFile);
    
            String getFile = FireCodeUtils.makeGet(table, author, module, basePackage, baseDir);
            getLog().info("create file " + getFile);
    
            String searchFile = FireCodeUtils.makeSearch(table, author, module, basePackage, baseDir);
            getLog().info("create file " + searchFile);
    
            String respFile = FireCodeUtils.makeResp(table, author, module, basePackage, baseDir);
            getLog().info("create file " + respFile);
            
            String managerFile = FireCodeUtils.makeManager(table, author, module, basePackage, baseDir);
            getLog().info("create file " + managerFile);
            
            String managerImplFile = FireCodeUtils.makeManagerImpl(table, author, module, basePackage, baseDir);
            getLog().info("create file " + managerImplFile);
            
            String serviceFile = FireCodeUtils.makeService(table, author, module, basePackage, baseDir);
            getLog().info("create file " + serviceFile);
            
            String serviceImplFile = FireCodeUtils.makeServiceImpl(table, author, module, basePackage, baseDir);
            getLog().info("create file " + serviceImplFile);
            
            String testServiceFile = FireCodeUtils.makeServiceTest(table, author, module, basePackage, baseDir);
            getLog().info("create file " + testServiceFile);
            
        } catch (Exception e) {
            throw new MojoExecutionException("init error", e);
        }
    }
}
