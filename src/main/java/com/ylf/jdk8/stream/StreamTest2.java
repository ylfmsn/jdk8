package com.ylf.jdk8.stream;

import java.util.stream.IntStream;

public class StreamTest2 {
    public static void main(String[] args) {

        IntStream.of(new int[]{1, 3, 5, 7,}).forEach(System.out::println);
        System.out.println("-------");

        IntStream.range(2, 7).forEach(System.out::println);
        System.out.println("-------");

        IntStream.rangeClosed(2, 7).forEachOrdered(System.out::println);
        System.out.println("-------");
    }
}
