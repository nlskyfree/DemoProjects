package com.skyfree.maven.config;


import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;
import com.skyfree.maven.common.utils.PropertiesUtils;

@Configuration
public class DataSourceConfig {
    
    private static Properties props;
    
    static {
        try {
            props = PropertiesUtils.readProperteis("datasource.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Primary
    @Bean(name = "mysqlDataSource")
    @Qualifier("mysqlDataSource")//spring装配bean唯一标识
    public DataSource mysqlDataSource() throws Exception {
        DruidDataSource ds = new DruidDataSource();
        Map<String, String> mysqlProps = PropertiesUtils.readPropsByPrefix(props, "spring.datasource.mysql");
        BeanUtils.copyProperties(ds, mysqlProps);
        return ds;
    }
    
    //MySQL JdbcTemplate
    @Bean(name = "mysqlJdbcTemplate")
    public JdbcTemplate ontologyJdbcTemplate(@Qualifier("mysqlDataSource") DataSource mysqlDataSource) {
        return new JdbcTemplate(mysqlDataSource);
    }
}
