package com.mybatis.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.beans.PropertyVetoException;

/**
 * @Author create by  huarong
 * @Date ${Date} ${Time}
 */
@Configuration
@MapperScan("com.mybatis.dao")
public class DataSourceConfiguration {
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.password}")
    private String jdbcPassword;
    @Value("${jdbc.username}")
    private String jdbcUsername;

    @Bean(name = "dataSource")
    public ComboPooledDataSource createDateSource() throws PropertyVetoException {
        ComboPooledDataSource driverManagerDataSource =new ComboPooledDataSource();
        driverManagerDataSource.setDriverClass(jdbcDriver);
        driverManagerDataSource.setJdbcUrl(jdbcUrl);
        driverManagerDataSource.setPassword(jdbcPassword);
        driverManagerDataSource.setUser(jdbcUsername);
        //关闭连接后不做自动提交
        driverManagerDataSource.setAutoCommitOnClose(false);
        return driverManagerDataSource;
    }
}
