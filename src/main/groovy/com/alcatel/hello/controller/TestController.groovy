package com.alcatel.hello.controller

import com.alcatel.hello.domain.Greeting
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

import java.util.concurrent.atomic.AtomicLong

@Controller
class TestController {

    final static String template = "Hello, %s!"
    final AtomicLong counter = new AtomicLong()

    @RequestMapping("/test")
    public String test() {
        "Hello test"
    }

    @RequestMapping("/testGreeting")
    public @ResponseBody
    Greeting testGreeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        new Greeting(id: counter.incrementAndGet(), content: String.format(template, name))
    }

}