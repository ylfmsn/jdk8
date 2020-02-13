package com.ylf.jdk8;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * BinaryOperator<T>是BiFunction<T, V, R>的一种特例，
 */
public class BinaryOperatorTest {

    public static void main(String[] args) {

        BinaryOperatorTest test = new BinaryOperatorTest();
        int a = 5;
        int b = 6;

        // 相加
        System.out.println(test.operator(a, b, (val1, val2) -> val1 + val2));
        System.out.println("--------------");

        // 相减
        System.out.println(test.operator(a, b, (val1, val2) -> val1 - val2));
        System.out.println("------------");

        // 相乘
        System.out.println(test.operator(a, b, (val1, val2) -> val1 * val2));
        System.out.println("------------");

        // 相除
        System.out.println(test.operator(a, b, (val1, val2) -> val1 / val2));

        System.out.println(test.getShort("hello123", "word", (val1, val2) -> val1.length() - val2.length()));
        System.out.println(test.getShort("hello123", "word", (val1, val2) -> val1.charAt(0) - val2.charAt(0)));
    }

    public int operator(int a, int b, BinaryOperator<Integer> binaryOperator) {
        return binaryOperator.apply(a, b);
    }

    public String getShort(String a, String b, Comparator<String> comparator) {
        return BinaryOperator.minBy(comparator).apply(a, b);
    }
}
