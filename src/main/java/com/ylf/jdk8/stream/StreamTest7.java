package com.ylf.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * 中间操作与终止操作区别
 */
public class StreamTest7 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");
        //list.stream().map(item -> item.substring(0, 1).toUpperCase() + item.substring(1)).forEach(System.out::println);

        // 以下代码不执行，因为只有中间操作没有终止操作，只有遇到终止操作时中间操作才会执行
        list.stream().map(item -> {
            String result = item.substring(0, 1).toUpperCase() + item.substring(1);
            System.out.println("test");
            return result;
        });
    }
}
