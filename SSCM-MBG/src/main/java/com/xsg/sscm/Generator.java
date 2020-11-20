package com.xsg.sscm;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * mbg生成代码
 * Created by xsg on 2020/2/12 14:33
 */
public class Generator {
    public static void main(String[] args)throws Exception{
        //读取mbg配置文件
        InputStream input = Generator.class.getResourceAsStream("/GeneratorConfig.xml");

        //存放警告信息
        List<String> warnings = new ArrayList<>();

        //覆盖原来重复的mbg生成代码
        boolean overwrite = true;

        ConfigurationParser cp  = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(input);
        input.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        //创建 MBG
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        //执行生成代码
        myBatisGenerator.generate(null);
        //输出警告信息
        for (String warning : warnings) {
            System.out.println(warning);
        }
        }
    }

