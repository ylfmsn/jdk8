package com.ylf.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest12 {

    public static void main(String[] args) {
        // 要求两个集合交叉合并输出：Hi zhangsan， Hi lisi, Hi wangwu, Hello zhangsan。。。。。。
        List<String> list1 = Arrays.asList("Hi", "Hello", "你好");
        List<String> list2 = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");

        // 使用flatMap将组合打平
        list1.stream().flatMap(item -> list2.stream().map(item2 -> item + " " + item2))
                .collect(Collectors.toList()).forEach(System.out::println);
    }
}
