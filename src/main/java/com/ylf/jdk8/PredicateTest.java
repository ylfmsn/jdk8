package com.ylf.jdk8;

import java.util.function.Predicate;

/**
 * 函数式接口Predicate<T>简单举例
 */
public class PredicateTest {

    public static void main(String[] args) {

        Predicate<String> predicate = str -> str.equals("zhangsan");

        // test的具体实现在predicate的定义上
        System.out.println(predicate.test("zhangsan"));
    }
}
