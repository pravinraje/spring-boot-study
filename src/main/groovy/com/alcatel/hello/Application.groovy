package com.alcatel.hello

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan
@EnableAutoConfiguration
class Application {
    static void main(String[] args) {
        SpringApplication.run Application, args
    }

    @Bean
    SecurityProperties securityProperties() {
        SecurityProperties security = new SecurityProperties()
        security.basic.path = "" // empty so home page is unsecured
        security
    }
}