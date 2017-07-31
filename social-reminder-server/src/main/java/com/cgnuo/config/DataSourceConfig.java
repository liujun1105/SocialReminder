package com.cgnuo.config;

import com.cgnuo.properties.DataSourceProperties;
import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    private Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    @Autowired
    DataSourceProperties dataSourceProperties;

    @Bean("mysqlDataSource")
    public DataSource mysqlDataSource() {
        logger.info("init MySQL DataSource");
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        dataSource.setUrl(dataSourceProperties.getUrl());
        dataSource.setUsername(dataSourceProperties.getUsername());
        dataSource.setPassword(dataSourceProperties.getPassword());
        dataSource.setMinIdle(dataSourceProperties.getMinIdle());
        dataSource.setMaxIdle(dataSourceProperties.getMaxIdle());
        dataSource.setMaxTotal(dataSourceProperties.getMaxTotal());
        dataSource.setInitialSize(dataSourceProperties.getInitSize());
        return dataSource;
    }

    @Bean("mysqlJdbcTemplate")
    public JdbcTemplate mysqlJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(mysqlDataSource());
        return jdbcTemplate;
    }

    @Bean
    @Profile("dev")
    public DataSourceInitializer dataSourceInitializer() {
        logger.info("init DataSourceInitializer");

        final DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(mysqlDataSource());
        dataSourceInitializer.setDatabasePopulator(databasePopulator());
        return dataSourceInitializer;
    }

    private DatabasePopulator databasePopulator() {
        logger.info("init ResourceDatabasePopulator");

        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new FileSystemResource(System.getProperty("datasource.script.schema")));
        populator.addScript(new FileSystemResource(System.getProperty("datasource.script.data")));
        return populator;
    }

}
