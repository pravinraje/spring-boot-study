package com.alcatel.hello.domain;

/**
 * Created by guoshunw on 2014/5/4.
 */
public class HelloMessage {

    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("HelloMessage{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
