package com.github.K0zka.kotlin

import com.github.K0zka.HelloService

public class KotlinHello : HelloService {
	override fun greet(name: String?): String {
		return "Hello ${name}!"
	}
}