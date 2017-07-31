package com.cgnuo.config;

import com.cgnuo.properties.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
    DataSourceConfig.class
})
@EnableConfigurationProperties({
    DataSourceProperties.class
})
public class ApplicationConfig {
}
