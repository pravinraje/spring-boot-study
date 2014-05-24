package com.alcatel.hello.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created by Administrator on 2014/5/24 0024.
 */
@Controller
class IndexController {

    private static Logger log = LoggerFactory.getLogger(GreetingController)

    @RequestMapping("/")
    String indexHandler() {
        log.info("Access Index control index method")
        "index"
    }

}
