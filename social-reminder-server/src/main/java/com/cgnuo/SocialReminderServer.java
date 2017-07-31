package com.cgnuo;

import com.cgnuo.config.ApplicationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

import java.util.Arrays;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {
//    HibernateJpaAutoConfiguration.class,
//    DataSourceAutoConfiguration.class,
//    DataSourceTransactionManagerAutoConfiguration.class
//})
@Import({
    ApplicationConfig.class
})
public class SocialReminderServer {

    private static Logger logger = LoggerFactory.getLogger(SocialReminderServer.class);

    public static void main(String[] args) throws Exception {

        Arrays.stream(args).forEach(arg -> logger.info("argument -> " + arg));

        SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder();

        springApplicationBuilder.bannerMode(Banner.Mode.CONSOLE)
                .sources(SocialReminderServer.class)
                .run(args);
    }
}
