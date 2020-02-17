package com.ylf.jdk8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest11 {
    public static void main(String[] args) {
        /**
         * 集合元素由若干个单词组成，找出相同单词，然后去重
         * 如下结果为：hello world welcome
         */
        List<String> list = Arrays.asList("hello world", "world hello",
                "hello world hello", "hello welcome");

        list.stream().map(item -> item.split(" ")).flatMap(strings -> Arrays.stream(strings)).
                distinct().forEach(System.out::println);
    }
}
