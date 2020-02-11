package com.ylf.jdk8;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Function接口下的compose和andThen方法
 */
public class FunctionTest2 {

    public static void main(String[] args) {
        FunctionTest2 test = new FunctionTest2();

        System.out.println(test.compute(2, value -> value * 3, value -> value * value));
        System.out.println(test.compute1(2, value -> value * 3, value -> value * value));

        System.out.println(test.compute2(2, 3, (value1, value2) -> value1 + value2));
        System.out.println(test.compute2(2, 3, (value1, value2) -> value1 - value2));
    }

    /**
     * 将输入参数先是执行function2的apply，然后将执行的结果作为参数传递给function1，执行function1的apply
     */
    public int compute(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.compose(function2).apply(a);
    }

    /**
     *  先执行function1的apply，然后将结果作为参数执行function2的apply
     */
    public int compute1(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.andThen(function2).apply(a);
    }

    /**
     * BiFunction
     */
    public int compute2(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }



}
