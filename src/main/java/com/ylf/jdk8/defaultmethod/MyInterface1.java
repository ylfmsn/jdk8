package com.ylf.jdk8.defaultmethod;

public interface MyInterface1 {

    default void myMethod() {
        System.out.println("my interface1");
    }
}
