package com.github.K0zka.scala

import com.github.K0zka.HelloService

class ScalaHello extends HelloService {
    def greet(name : String) : String = {
      return s"Hello $name!"
    }
}
