package com.alcatel.hello.controller;

import com.alcatel.hello.domain.Greeting;

import com.alcatel.hello.domain.HelloMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by guoshunw on 2014/5/4.
 */

@Controller
public class GreetingController {
    private static Logger log = LoggerFactory.getLogger(GreetingController.class);

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        log.info("greeting with message {}", message);
        SECONDS.sleep(1);
        return new Greeting("Hello, " + message.getName() + "!");
    }
}
