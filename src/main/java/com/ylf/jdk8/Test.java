package com.ylf.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

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
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        System.out.println("----------");

        // 函数式接口Function<T, R>, T表示输入参数，R表示输出结果
        /**
         * 对于String类型的实例方法toUperCase()是没有参数的，这个时候输入参数T为调用toUperCase方法的对象，
         * 所以String类型的对象就是作为函数式接口Function的第一个参数T，而toUperCase方法返回一个String类型的对象，
         * 所以该方法返回的String类型的对象作为函数式接口Function的第二个参数R
         */
        Function<String, String> function = String::toUpperCase;
        System.out.println(function.getClass().getInterfaces()[0]);


    }
}
