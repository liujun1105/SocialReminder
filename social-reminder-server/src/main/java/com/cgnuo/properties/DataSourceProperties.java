package com.cgnuo.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;

@ConfigurationProperties
public class DataSourceProperties {

    private Logger logger = LoggerFactory.getLogger(DataSourceProperties.class);

    @Value(value = "${db.mysql.driverClassName}")
    private String driverClassName;

    @Value(value = "${db.mysql.url}")
    private String url;

    @Value(value = "${db.mysql.username}")
    private String username;

    @Value(value = "${db.mysql.password}")
    private String password;

    @Value(value = "${db.mysql.initSize:3}")
    private int initSize;

    @Value(value = "${db.mysql.minIdle:10}")
    private int minIdle;

    @Value(value = "${db.mysql.maxIdle:20}")
    private int maxIdle;

    @Value(value = "${db.mysql.maxTotal:30}")
    private int maxTotal;

    @Override
    public String toString() {
        return "DataSourceProperties{" +
                "driverClassName='" + driverClassName + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", initSize=" + initSize +
                ", minIdle=" + minIdle +
                ", maxIdle=" + maxIdle +
                ", maxTotal=" + maxTotal +
                '}';
    }

    @PostConstruct
    public void postConstruct() {
        logger.info(toString());
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getInitSize() {
        return initSize;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

}
