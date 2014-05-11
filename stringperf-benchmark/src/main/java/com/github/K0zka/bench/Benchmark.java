package com.github.K0zka.bench;

import com.github.K0zka.HelloService;
import com.github.K0zka.groovy.GroovyHello;
import com.github.K0zka.java.JavaHello;
import com.github.K0zka.kotlin.KotlinHello;
import com.github.K0zka.scala.ScalaHello;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kocka on 5/10/14.
 */
public class Benchmark {

    static HelloService clojureHello;
    static {
        try {
            clojureHello = (HelloService)Class.forName("hello").newInstance();
        } catch (Exception cnfe) {
            cnfe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Map<String, Long> bestResults = new HashMap<String, Long>();
        for (int round = 0; round < 100; round++) {
            for (HelloService helloService : new HelloService[]{
                    new ScalaHello(),
                    new KotlinHello(),
                    new JavaHello(),
                    new GroovyHello(),
                    clojureHello}) {
                long start = System.currentTimeMillis();
                for (int i = 0; i < 1000000; i++) {
                    String greeting = helloService.greet("world");
                    if (!"Hello world!".equals(greeting)) {
                        throw new IllegalStateException(helloService.getClass().getName() + ":" + greeting);
                    }
                }
                long end = System.currentTimeMillis();
                String langName = helloService.getClass().getName();
                long result = (end - start);
                if(!bestResults.containsKey(langName) || bestResults.get(langName) > result) {
                    bestResults.put(langName, result);
                }
                System.out.println("round "+round);
            }
        }
        for(Map.Entry<String, Long> entry :  bestResults.entrySet()) {
            System.out.println( entry.getKey()+ "\t" + entry.getValue());
        }

    }
}