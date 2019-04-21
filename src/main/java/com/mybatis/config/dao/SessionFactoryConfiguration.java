package com.mybatis.config.dao;


import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @Author create by  huarong
 * @Date ${Date} ${Time}
 */
@Configuration
public class SessionFactoryConfiguration {
    //mybatis配置文件
    @Value("${mybatis_config_file}")
    private  String mybatisConfigFilePath;
    //mapper路径
    @Value("${mapper_path}")
    private  String mapperPath;
    //实体类所在路径
    @Value("${entity_package}")
    private String entityPackage;
    //链接池
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        //加载配置文件
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
        PathMatchingResourcePatternResolver resolver =new PathMatchingResourcePatternResolver();
        String packageSearchPath=PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX+mapperPath;
        //设置mapper路径
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
        //加载连接池
        sqlSessionFactoryBean.setDataSource(dataSource);
        //设置实体类路径
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
        return sqlSessionFactoryBean;
    }
}
