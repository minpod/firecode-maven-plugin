package com.youzan.beauty.util;

import com.youzan.beauty.util.code.FileUtil;
import com.youzan.beauty.util.code.PathUtil;
import com.youzan.beauty.util.code.VelocityUtil;
import com.youzan.beauty.util.database.Table;

import java.io.File;


/**
 * Created by mingle.
 * Time 2017/11/7 下午8:28
 * Desc 文件描述
 */
public class FireCodeUtils {
    
    public static String makeSql(Table table, String author, String module, String basePackage) {
        String path = PathUtil.getResourcesPath() + File.separator + "mybatis" + File.separator + "mapper" + File.separator + module + File.separator + table.getClazzName() + "Mapper" + ".xml";
        String code = VelocityUtil.make(author, basePackage, module, table, "sql.vm");
        FileUtil.writeToFile(path, code);
        return path;
    }
    
    
    public static String makeDO(Table table, String author, String module, String basePackage, String baseDir) {
        String dal = File.separator + "dal" + File.separator + "dataobject" + File.separator;
        String doFile = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + dal + table.getClazzName() + "DO.java";
        String doCode = VelocityUtil.make(author, basePackage, module, table, "do.vm");
        FileUtil.writeToFile(doFile, doCode);
        return doFile;
    }
    
    
    public static String makeMapper(Table table, String author, String module, String basePackage, String baseDir) {
        String mapper = File.separator + "dal" + File.separator + "mapper" + File.separator;
        String mapperFile = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + mapper + table.getClazzName() + "Mapper.java";
        String mapperCode = VelocityUtil.make(author, basePackage, module, table, "mapper.vm");
        FileUtil.writeToFile(mapperFile, mapperCode);
        return mapperFile;
    }
    
    
    public static String makeTransUtils(Table table, String author, String module, String basePackage, String baseDir) {
        String trans = File.separator + "utils" + File.separator;
        String transFile = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + trans + table.getClazzName() + "TransUtils.java";
        String transCode = VelocityUtil.make(author, basePackage, module, table, "trans.vm");
        FileUtil.writeToFile(transFile, transCode);
        return transFile;
    }
    
    
    public static String makeDTO(Table table, String author, String module, String basePackage, String baseDir) {
        String dto = File.separator + "model" + File.separator + "dto" + File.separator;
        String dtoFile = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + dto + table.getClazzName() + "DTO.java";
        String dtoCode = VelocityUtil.make(author, basePackage, module, table, "dto.vm");
        FileUtil.writeToFile(dtoFile, dtoCode);
        return dtoFile;
    }
    
    
    public static String makeReq(Table table, String author, String module, String basePackage, String baseDir) {
        String query = File.separator + "model" + File.separator + "req" + File.separator;
        String queryFile = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + query + table.getClazzName() + "Query.java";
        String queryCode = VelocityUtil.make(author, basePackage, module, table, "query.vm");
        FileUtil.writeToFile(queryFile, queryCode);
        return queryFile;
    }
    
    
    public static String makeQuery(Table table, String author, String module, String basePackage, String baseDir) {
        String query = File.separator + "model" + File.separator + "query" + File.separator;
        String queryFile = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + query + table.getClazzName() + "Query.java";
        String queryCode = VelocityUtil.make(author, basePackage, module, table, "query.vm");
        FileUtil.writeToFile(queryFile, queryCode);
        return queryFile;
    }
    
    
    public static String makeParam(Table table, String author, String module, String basePackage, String baseDir) {
        String param = File.separator + "model" + File.separator + "param" + File.separator;
        String queryFile = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + param + table.getClazzName() + "Param.java";
        String queryCode = VelocityUtil.make(author, basePackage, module, table, "param.vm");
        FileUtil.writeToFile(queryFile, queryCode);
        return queryFile;
    }
    
    
    public static String makeCreate(Table table, String author, String module, String basePackage, String baseDir) {
        String file = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + File.separator + "model" + File.separator + "param" + File.separator + table.getClazzName() +
                "CreateParam.java";
        String code = VelocityUtil.make(author, basePackage, module, table, "param_create.vm");
        FileUtil.writeToFile(file, code);
        return file;
    }
    
    
    public static String makeUpdate(Table table, String author, String module, String basePackage, String baseDir) {
        String file = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + File.separator + "model" + File.separator + "param" + File.separator + table.getClazzName() +
                "UpdateParam.java";
        String code = VelocityUtil.make(author, basePackage, module, table, "param_update.vm");
        FileUtil.writeToFile(file, code);
        return file;
    }
    
    
    public static String makeGet(Table table, String author, String module, String basePackage, String baseDir) {
        String file = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + File.separator + "model" + File.separator + "query" + File.separator + table.getClazzName() +
                "GetQuery.java";
        String code = VelocityUtil.make(author, basePackage, module, table, "query_get.vm");
        FileUtil.writeToFile(file, code);
        return file;
    }
    
    
    public static String makeSearch(Table table, String author, String module, String basePackage, String baseDir) {
        String file = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + File.separator + "model" + File.separator + "query" + File.separator + table.getClazzName() + "SearchQuery.java";
        String code = VelocityUtil.make(author, basePackage, module, table, "query_search.vm");
        FileUtil.writeToFile(file, code);
        return file;
    }
    
    
    public static String makeResp(Table table, String author, String module, String basePackage, String baseDir) {
        String file = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + File.separator + "model" + File.separator + "dto" + File.separator + table.getClazzName() + "DTO.java";
        String code = VelocityUtil.make(author, basePackage, module, table, "dto.vm");
        FileUtil.writeToFile(file, code);
        return file;
    }
    
    
    public static String makeManager(Table table, String author, String module, String basePackage, String baseDir) {
        String manager = File.separator + "manager" + File.separator;
        String managerFile = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + manager + table.getClazzName() + "Manager.java";
        String managerCode = VelocityUtil.make(author, basePackage, module, table, "manager.vm");
        FileUtil.writeToFile(managerFile, managerCode);
        return managerFile;
    }
    
    
    public static String makeManagerImpl(Table table, String author, String module, String basePackage, String baseDir) {
        String managerImpl = File.separator + "manager" + File.separator + "impl" + File.separator;
        String managerImplFile = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + managerImpl + table.getClazzName() + "ManagerImpl.java";
        String managerImplCode = VelocityUtil.make(author, basePackage, module, table, "manager_impl.vm");
        FileUtil.writeToFile(managerImplFile, managerImplCode);
        return managerImplFile;
    }
    
    
    public static String makeTest(Table table, String author, String module, String basePackage, String baseDir) {
        String testFile = PathUtil.getTestPath() + File.separator + baseDir + File.separator + module + File.separator + "mapper" + File.separator + table.getClazzName() + "MapperTest.java";
        String testCode = VelocityUtil.make(author, basePackage, module, table, "mapper_test.vm");
        FileUtil.writeToFile(testFile, testCode);
        return testFile;
    }
    
    
    public static String makeService(Table table, String author, String module, String basePackage, String baseDir) {
        String service = File.separator + "service" + File.separator;
        String serviceFile = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + service + table.getClazzName() + "Service.java";
        String serviceCode = VelocityUtil.make(author, basePackage, module, table, "service.vm");
        FileUtil.writeToFile(serviceFile, serviceCode);
        return serviceFile;
    }
    
    
    public static String makeServiceTest(Table table, String author, String module, String basePackage, String baseDir) {
        String file = PathUtil.getTestPath() + File.separator + baseDir + File.separator + module + File.separator + "service" + File.separator + table.getClazzName() + "ServiceTest.java";
        String code = VelocityUtil.make(author, basePackage, module, table, "service_test.vm");
        FileUtil.writeToFile(file, code);
        return file;
    }
    
    
    public static String makeServiceImpl(Table table, String author, String module, String basePackage, String baseDir) {
        String path = File.separator + "service" + File.separator + "impl" + File.separator;
        String file = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + path + table.getClazzName() + "ServiceImpl.java";
        String code = VelocityUtil.make(author, basePackage, module, table, "service_impl.vm");
        FileUtil.writeToFile(file, code);
        return file;
    }
}
