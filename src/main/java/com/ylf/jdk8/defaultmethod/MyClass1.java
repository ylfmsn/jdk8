package com.ylf.jdk8.defaultmethod;

public class MyClass1 extends MyInterface1Impl implements MyInterface2 {
    public static void main(String[] args) {
        MyClass1 myClass1 = new MyClass1();
        // 继承的是MyInterface1Impl类的方法，编译器认为继承的类比实现的接口的同名方法更加具体
        myClass1.myMethod();
    }
}
