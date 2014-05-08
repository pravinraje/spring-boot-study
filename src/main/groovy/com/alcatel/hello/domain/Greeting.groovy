package com.alcatel.hello.domain

import grails.persistence.Entity

/**
 * Created by guoshunw on 2014/5/8.
 */

class Greeting {

    Greeting() {
    }

    Greeting(String content) {
        this.content = content
    }
    String content
    Long id


    @Override
    public String toString() {
        return """\
Greeting{
    content='$content',
    id=$id
}"""
    }
}
