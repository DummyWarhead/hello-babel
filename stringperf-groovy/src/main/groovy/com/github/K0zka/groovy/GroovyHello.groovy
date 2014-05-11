package com.github.K0zka.groovy

import com.github.K0zka.AbstractHelloService
import com.github.K0zka.HelloService

class GroovyHello extends AbstractHelloService {
    @Override
    public String greet(String name) {
        return "Hello $name!"
    }
}

