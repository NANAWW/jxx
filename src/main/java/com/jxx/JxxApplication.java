package com.jxx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.jxx.dao")
public class JxxApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder createSpringApplicationBuilder() {
        return createSpringApplicationBuilder().sources(this.getClass());
    }

    public static void main(String[] args) {
        SpringApplication.run(JxxApplication.class, args);
    }

}
