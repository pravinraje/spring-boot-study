package com.alcatel.hello.actuator.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 * Created by guoshunw on 2014/5/6.
 */

@Controller
public class SampleActuatorUIApplication {

    @RequestMapping("/")
    public String home(Map<String, Object> model) {
        model.put("message", "Hello world");
        model.put("title", "Hello home");
        model.put("date", new Date());
        return "home";
    }

    @RequestMapping("foo")

    public String foo() {
        throw new RuntimeException("Expected exception in controller");
    }
}
