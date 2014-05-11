package com.github.K0zka.java;

import com.github.K0zka.HelloService;

public class JavaHello implements HelloService
{

    public String greet(final String name) {
        return "Hello "+name+"!";
    }
}
