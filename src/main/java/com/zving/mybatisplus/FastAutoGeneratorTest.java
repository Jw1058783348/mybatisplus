package com.zving.mybatisplus;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.INameConvert;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 快速生成
 * </p>
 */
public class FastAutoGeneratorTest {

    /**
     * 执行初始化数据库脚本
     */
    public static void before() throws SQLException {
//        Connection conn = DATA_SOURCE_CONFIG.build().getConn();
//        InputStream inputStream = H2CodeGeneratorTest.class.getResourceAsStream("/sql/init.sql");
//        ScriptRunner scriptRunner = new ScriptRunner(conn);
//        scriptRunner.setAutoCommit(true);
//        scriptRunner.runScript(new InputStreamReader(inputStream));
//        conn.close();
    }

    /**
     * 数据源配置
     */
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
        .Builder("jdbc:mysql://localhost:3306/mp?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true", "root", "123456");

    /**
     * 执行 run
     */
    public static void main(String[] args) throws SQLException {
        before();
        Map map = new HashMap<String, String>();
        map.put(OutputFile.mapperXml, "E:/idea_workspace/mybatisplus/src/main/resources");
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                .templateEngine(new FreemarkerTemplateEngine())// 设置模板引擎
            // 全局配置
            .globalConfig((scanner, builder) -> builder.author("JiangWei").fileOverride().outputDir("E:/idea_workspace/mybatisplus/src/main/java"))
            // 包配置
            .packageConfig((scanner, builder) -> builder.parent("com.zving.mybatisplus").controller("ui").pathInfo(map))
            // 策略配置
            .strategyConfig(builder -> builder.addInclude("zcmember").addTablePrefix("t_", "c_").enableCapitalMode().entityBuilder().enableLombok().enableTableFieldAnnotation()
            .entityBuilder().nameConvert(new INameConvert() {
                                @Override
                                public @org.jetbrains.annotations.NotNull String entityNameConvert(@org.jetbrains.annotations.NotNull TableInfo tableInfo) {
                                    String entityName = tableInfo.getName();
                                    if(entityName.startsWith("b")){
                                        entityName = entityName.substring(0,4).toUpperCase()+entityName.substring(4);
                                    }else{
                                        entityName = entityName.substring(0,3).toUpperCase()+entityName.substring(3);
                                    }
                                    return entityName;
                                }

                                @Override
                                public @org.jetbrains.annotations.NotNull String propertyNameConvert(@org.jetbrains.annotations.NotNull TableField field) {
                                    String name = field.getName();
                                    return name;
                                }
                            }).enableActiveRecord()
                            .controllerBuilder().formatFileName("%sUI").enableRestStyle()//.superClass(BaseController.class)
                            .serviceBuilder().formatServiceFileName("%sService")
            )//设置过滤表前缀
            //模板配置
            //指定自定义模板路径, 位置：/resources/templates/entity2.java.ftl(或者是.vm)
            //注意不要带上.ftl(或者是.vm), 会根据使用的模板引擎自动识别
            .templateConfig(builder -> builder.disable(TemplateType.CONTROLLER)//禁用生成controller
                    .entity("/templates/entity.java"))
            .execute();
    }
}