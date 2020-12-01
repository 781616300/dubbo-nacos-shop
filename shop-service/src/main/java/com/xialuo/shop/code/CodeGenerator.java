package com.xialuo.shop.code;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import java.io.File;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

/**
 * @author lvzhyong
 * @date 2020/6/29 20:10
 */
public class CodeGenerator {

    /**
     * 项目绝对路径（需要修改为自己的路径）
     */
    private static final String PROJECT_PATH = System.getProperty("user.dir") + File.separator + "shop-service" + File.separator  ;

    private static String  moduleName = "";

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig globalConfig = assembleGlobalConfig();
        mpg.setGlobalConfig(globalConfig);

        // 数据源配置（配置的开发环境数据源）
        DataSourceConfig dataSourceConfig = assembleDataSourceConfig();
        mpg.setDataSource(dataSourceConfig);

        // 包配置
        PackageConfig packageConfig = assemblePackageConfig();
        mpg.setPackageInfo(packageConfig);

        // 自定义配置
//    GenerateTemplateEntrance generateTemplateEntrance = new GenerateTemplateEntrance(
//         new XmlTemplateStrategy());
//    InjectionConfig xmlcfg =  generateTemplateEntrance.generateTemplate(moduleName);
//    mpg.setCfg(xmlcfg);

        // 配置模板
        TemplateConfig templateConfig = assembleTemplateConfig();
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = assembleStrategyConfig();
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * 全局配置
     */
    public static GlobalConfig assembleGlobalConfig() {
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(PROJECT_PATH + "/src/main/java");
        gc.setAuthor(scanner("作者"));
        gc.setDateType(DateType.TIME_PACK);
        gc.setOpen(false);
        gc.setBaseResultMap(true);
//    gc.setBaseColumnList(true);
//    gc.setEnableCache(true);
        //实体属性 Swagger2 注解
        gc.setSwagger2(true);
        moduleName = scanner("模块名");
        String moduleNameToUpper = moduleName.substring(0, 1).toUpperCase() + moduleName.substring(1);
        gc.setServiceImplName("%sRepository");
        gc.setServiceName(moduleNameToUpper + "Service");
        return gc;
    }

    /**
     * 数据源配置
     */
    public static DataSourceConfig assembleDataSourceConfig() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(
            "jdbc:mysql://127.0.0.1:3306/coupon?autoReconnect=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false&serverTimezone=CTT");
        dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setDbType(DbType.MYSQL);
        return dsc;
    }

    /**
     * 包配置
     */
    public static PackageConfig assemblePackageConfig() {
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(moduleName);
        pc.setServiceImpl("repository");
        pc.setMapper("repository.mapper");
        pc.setXml(pc.getMapper() + ".xml");
        pc.setParent("com.xialuo.shop");
        return pc;
    }

    /**
     * 模板配置
     */
    public static TemplateConfig assembleTemplateConfig() {
        // 配置模板(当您设置为null,时，该模块不会生成)
        TemplateConfig templateConfig = new TemplateConfig();
        // 配置自定义输出模板    //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        templateConfig.setController(null);
        templateConfig.setServiceImpl("/templates/Repository.java");
        templateConfig.setEntity("/templates/entity.java");
        return templateConfig;
    }

    /**
     * 策略配置
     */
    public static StrategyConfig assembleStrategyConfig() {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//    strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
//    strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
//    strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix("gz_");
        return strategy;
    }
}
