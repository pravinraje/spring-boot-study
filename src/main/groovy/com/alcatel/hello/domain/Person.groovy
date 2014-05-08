package com.alcatel.hello.domain

import grails.persistence.Entity

/**
* Created by guoshunw on 2014/5/7.
*/

@Entity
class Person {
    String firstName
    String lastName

    static constraints = {
        firstName blank: false
        lastName blank: false
    }
}
