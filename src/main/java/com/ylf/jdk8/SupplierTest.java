package com.ylf.jdk8;

import java.util.function.Supplier;

/**
 * Supplier<T>，不接收参数同时返回一个结果
 */
public class SupplierTest {

    public static void main(String[] args) {
        Supplier<String> supplier = () -> "hello world";
        System.out.println(supplier.get());
        System.out.println("------------");

        Supplier<Student> supplier1 = () -> new Student();
        System.out.println(supplier1.get().getName());
        System.out.println("------------");

        // 方法引用
        Supplier<Student> supplier2 = Student::new;
        System.out.println(supplier2.get().getName());
    }
}
