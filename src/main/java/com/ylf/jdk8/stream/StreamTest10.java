package com.ylf.jdk8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest10 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello1", "world", "hello world");

        /**
         * 找出第一个长度为5的单词
         * stream中的元素会进行所有的操作，如果发现某个元素符合条件就不会对流的下个元素继续操作
         * 输出结果为： hello1 world 5
         */
        list.stream().mapToInt(item -> {
            int length = item.length();
            System.out.println(item);
            return length;
        }).filter(length -> length == 5).findFirst().ifPresent(System.out::println);
    }
}
