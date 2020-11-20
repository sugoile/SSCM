package com.xsg.sscm.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"com.xsg.sscm.mapper","com.xsg.sscm.dao"})
public class MybtisConfig {
}
