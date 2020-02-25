package com.ylf.jdk8.stream2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyComparatorTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("nihao", "hello", "world", "welcome");

        // 按照长度升序排序
        //Collections.sort(list, (item1, item2) -> item1.length() - item2.length());

        // 按照长度降序排序
        //Collections.sort(list, (item1, item2) -> item2.length() - item1.length());

        // 长度降序排序，方法引用
        //Collections.sort(list, Comparator.comparingInt(String::length).reversed());

        /**
         *  编译器无法解析item类型，此时需要显式声明item参数类型
         *
         *  大多数情况下，对于lambda表达式编译器是可以推断出参数类型的
         *  comparingInt参数是Comparator比较器的元素或父元素，此时Comparator比较器元素是reversed()方法返回的类型String，所以lambda参数是String或String的父类，如果不显式指定String，编译器无法断定是String，只能认为是String及String父类的通用类型，即Object类型
         */
        //Collections.sort(list, Comparator.comparingInt((String item) -> item.length()).reversed());

        //list.sort(Comparator.comparingInt(String::length).reversed());

        //list.sort(Comparator.comparingInt((String item) -> item.length()).reversed());

        // 先按照长度排序，若长度相同，再按照ascii码不区分大小写进行比较，thenComparing被调用时机时前一个比较器的比较结果是0即比较元素相等时，thenComparing才会被调用
        //Collections.sort(list, Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER))
        //Collections.sort(list, Comparator.comparingInt(String::length).thenComparing((item1, item2) -> item1.compareToIgnoreCase(item2)));
        //Collections.sort(list, Comparator.comparingInt(String::length).thenComparing(Comparator.comparing(String::toLowerCase)));

        //Collections.sort(list, Comparator.comparingInt(String::length).thenComparing(Comparator.comparing(String::toLowerCase, Comparator.reverseOrder())));

        // 按长度降序，如果长度相同，按照ascii码降序
        Collections.sort(list, Comparator.comparingInt(String::length).reversed().
                thenComparing(Comparator.comparing(String::toLowerCase, Comparator.reverseOrder())));

        System.out.println(list);



    }


}
