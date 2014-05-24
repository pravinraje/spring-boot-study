package com.alcatel.hello

import org.logicalcobwebs.proxool.ProxoolDataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment

import javax.sql.DataSource

@Configuration
@ComponentScan
@EnableAutoConfiguration()
// file that contains the properties
@PropertySource("classpath:proxool.properties")
class Application {

    @Autowired
    private Environment env
    static void main(String[] args) {
        SpringApplication.run Application, args
    }

    @Bean
    SecurityProperties securityProperties() {
        SecurityProperties security = new SecurityProperties()
        security.basic.path = "" // empty so home page is unsecured
        security
    }

    @Bean
    DataSource dataSource() {
        ProxoolDataSource pds = new ProxoolDataSource(env.getProperty("jdbc.proxool.alias"))
        pds.driver = env.getProperty("jdbc.proxool.driver-class")
        pds.driverUrl = env.getProperty("jdbc.proxool.driver-url")
        pds.user = env.getProperty("jdbc.user")
        pds.password = env.getProperty("jdbc.password")

        pds.houseKeepingTestSql = env.getProperty("jdbc.proxool.house-keeping-test-sql")

        pds.houseKeepingSleepTime = Integer.parseInt env.getProperty("jdbc.proxool.house-keeping-sleep-time")
        pds.prototypeCount = Integer.parseInt env.getProperty("jdbc.proxool.prototype-count")
        pds.maximumConnectionCount = Integer.parseInt env.getProperty("jdbc.proxool.maximum-connection-count")
        pds.minimumConnectionCount = Integer.parseInt env.getProperty("jdbc.proxool.minimum-connection-count")
        pds.maximumActiveTime = Integer.parseInt env.getProperty("jdbc.proxool.maximum-active-time")
        pds
    }

}