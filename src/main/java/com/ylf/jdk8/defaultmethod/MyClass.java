package com.ylf.jdk8.defaultmethod;

public class MyClass implements MyInterface1, MyInterface2 {

    // 需要重写实现的两个接口的同名方法
    @Override
    public void myMethod() {
        // 指定实现MyInterface1接口的方法
        MyInterface1.super.myMethod();
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.myMethod();
    }
}
