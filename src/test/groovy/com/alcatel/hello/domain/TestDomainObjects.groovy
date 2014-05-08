/**
 * Created by Administrator on 2014/5/8 0008.
 */
package com.alcatel.hello.domain

import com.alcatel.hello.Application
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration

import java.util.concurrent.atomic.AtomicInteger


//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
//@IntegrationTest("server.port=0")
//@WebAppConfiguration
//@DirtiesContext
class TestDomainObjects {

    @Test
    void testGreeting(){
        Greeting greeting = new Greeting(id: new AtomicInteger().incrementAndGet(), content: "hello")

        println greeting
    }
}
