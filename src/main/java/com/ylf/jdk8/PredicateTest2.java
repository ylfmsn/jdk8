package com.ylf.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest2 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        PredicateTest2 predicateTest2 = new PredicateTest2();
        // 奇数
        predicateTest2.conditionFilter(list, item -> item % 2 != 0);
        System.out.println("----------------");
        // 偶数
        predicateTest2.conditionFilter(list, item -> item % 2 == 0);
        System.out.println("----------------");
        // 大于5
        predicateTest2.conditionFilter(list, item -> item > 5);
        System.out.println("----------------");
        // 小于4
        predicateTest2.conditionFilter(list, item -> item < 4);
        System.out.println("----------------");
        // 打印所有
        predicateTest2.conditionFilter(list, item -> true);
        System.out.println("----------------");
        // 一个都不打印
        predicateTest2.conditionFilter(list, item -> false);

    }

    public void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer integer : list) {
            if (predicate.test(integer)) {
                System.out.println(integer);
            }
        }
    }
}
