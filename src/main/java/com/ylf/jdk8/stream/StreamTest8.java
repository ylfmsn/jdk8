package com.ylf.jdk8.stream;

import java.util.stream.IntStream;

public class StreamTest8 {
    public static void main(String[] args) {
        /**
         * 会一直执行，以为iterate无限返回0 1 对于distinct来说会去重，但iterate不停的重复出现0 1 所以distinct会一直等待
         */
        IntStream.iterate(0, i -> (i + 1) % 2).distinct().limit(6).forEach(System.out::println);
        // 修改后会执行，取固定长度的流后再去重
        IntStream.iterate(0, i -> (i + 1) % 2).limit(6).distinct().forEach(System.out::println);
    }
}
