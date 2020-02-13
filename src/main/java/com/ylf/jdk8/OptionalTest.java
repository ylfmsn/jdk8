package com.ylf.jdk8;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {

        Optional<String> optional = Optional.of("hello");
        Optional<String> optional1 = Optional.ofNullable(null);
        Optional<String> optional2 = Optional.empty();

        // 传统方式
        /*if (optional.isPresent()) {
            System.out.println(optional.get());
        }*/

        // 使用Lambda表达式访问
        optional.ifPresent(item -> System.out.println(item));
        optional1.ifPresent(item -> System.out.println(item));
        optional2.ifPresent(item -> System.out.println(item));
        System.out.println("----------");

        // 如果存在值则返回该值，不存在则返回其他指定的值
        System.out.println(optional.orElse("world"));
        System.out.println(optional1.orElse("world"));
        System.out.println(optional2.orElse("world"));
        System.out.println("----------");

        // 如果存在值则返回该值，不存在的话返回orElseGet(Supplier<? extends T> other)中other的结果，other是一个supplier即不接收参数的同时返回一个结果
        System.out.println(optional.orElseGet(() -> "welcome"));
        System.out.println(optional1.orElseGet(() -> "welcome"));
        System.out.println(optional2.orElseGet(() -> "welcome"));
    }
}
