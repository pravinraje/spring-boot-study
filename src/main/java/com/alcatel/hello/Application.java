package com.alcatel.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by guoshunw on 2014/5/4.
 */

@ComponentScan
@EnableAutoConfiguration
public class Application {
    public static void main(String...args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public SecurityProperties securityProperties(){
        SecurityProperties security = new SecurityProperties();
        security.getBasic().setPath(""); // empty so home page is unsecured
        return security;
    }

}
