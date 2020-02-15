package com.ylf.jdk8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest3 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 1, 5, 9);
        // 源： list     map： 中间操作    reduce： 终止操作
        System.out.println(list.stream().map(item -> item * 2).reduce(0, Integer::sum));
    }
}
