package com.ylf.jdk8.stream;

import java.util.UUID;
import java.util.stream.Stream;

public class StreamTest6 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
        stream.findFirst().ifPresent(System.out::println);

        System.out.println("----------------");
        /**
         * 第一个参数作为第二个参数方法的参数，经过第二个参数运算后的结果，继续经过第一个参数方法的运算
         * iterate(a, f(b)) 限制三次遍历的情况下为 f(f(f(a)))
         */
        Stream.iterate(1, item -> item + 2).limit(7).forEach(System.out::println);
        System.out.println("----------------");

        /**
         * 1, 3, 5, 7, 9, 11
         * 找出大于2的元素，然后每个元素乘以2，然后忽略前俩元素，然后再取流中前俩元素，然后求元素的和
         */
        // 省略装箱，提高性能
        int a = Stream.iterate(1, item -> item + 2).limit(6).filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).sum();
        // 没有考虑装箱，一种通用方式
        int b = Stream.iterate(1, item -> item + 2).limit(6).filter(item -> item > 2).map(item -> item * 2).skip(2).limit(2).reduce(0, Integer::sum);
        System.out.println(a);
        System.out.println(b);
    }
}
