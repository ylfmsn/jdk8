package com.ylf.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Test {

    public static void main(String[] args) {
        //List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        /*for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("------------------");

        for (Integer i : list) {
            System.out.println(i);
        }

        System.out.println("------------------");*/

        /*list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        System.out.println("-----------");
        list.forEach(i -> {
            System.out.println(i);
        });

        System.out.println("-----------");
        // 方法引用
        list.forEach(System.out::println);*/

        List<String> list = Arrays.asList("hello", "word", "hello world");
        list.forEach(item -> System.out.println(item.toUpperCase()));
        System.out.println("----------");

        List<String> list1 = new ArrayList<>();
        list.forEach(item -> list1.add(item.toUpperCase()));
        list1.forEach(item -> System.out.println(item));
        System.out.println("----------");

        list.stream().map(item -> item.toUpperCase()).forEach(item -> System.out.println(item));
        System.out.println("----------");

        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
