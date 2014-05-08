package com.alcatel.hello.controller

import com.alcatel.hello.domain.Greeting
import com.alcatel.hello.domain.HelloMessage
import com.alcatel.hello.domain.Person
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static java.util.concurrent.TimeUnit.SECONDS
import static org.springframework.http.HttpStatus.BAD_REQUEST
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.POST

/**
 * Created by guoshunw on 2014/5/7.
 */

@RestController
class GreetingController {

    private static Logger log = LoggerFactory.getLogger(GreetingController)

    @RequestMapping(value = "/person/greet", method = GET)
    String greet(String firstName) {
        Person p = Person.findByFirstName(firstName)
        p ? "Hello ${p.firstName}!" : "Person ${p.firstName} not found"
    }

    @RequestMapping(value = "/person/add", method = POST)
    ResponseEntity<Person> addPerson(String firstName, String lastName) {
        Person.withTransaction {
            Person p = new Person(firstName: firstName, lastName: lastName).save()
            new ResponseEntity(p ? CREATED : BAD_REQUEST)
        }
    }

    /**
     * For the web socket message back
     * */
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        log.info("greeting with message {}", message)
        SECONDS.sleep(1)
        new Greeting("Hello, " + message.getName() + "!")
    }
}

