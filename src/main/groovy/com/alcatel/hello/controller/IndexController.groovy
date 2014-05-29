package com.alcatel.hello.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created by Administrator on 2014/5/24 0024.
 */
@Controller
@groovy.util.logging.Slf4j
class IndexController {

    @RequestMapping("/")
    String indexHandler() {

        log.info("Access Index control index method")
        "index"
    }

}
