package com.ylf.jdk8;

import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {

        FunctionTest test = new FunctionTest();
        // 函数式接口
        System.out.println(test.compute(1, value -> value * 2));
        //传统方式
        System.out.println(test.method(1));

        // 将function先定义好，然后调用
        Function<Integer, Integer> function = value -> value * 2;
        System.out.println(test.compute(1, function));

        System.out.println(test.convert(5, value -> String.valueOf(value + "Helloworld")));
    }

    public int compute(int a, Function<Integer, Integer> function) {
        // 表示返回一个参数a经过function行为处理后得到的一个结果，而function行为是调用compute方法的对象定义并当作参数传递的
        return function.apply(a);
    }

    public String convert(int a, Function<Integer, String> function) {
        return function.apply(a);
    }

    public int method(int a) {
        return 2 * a;
    }


}
