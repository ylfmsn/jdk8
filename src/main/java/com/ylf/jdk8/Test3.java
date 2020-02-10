package com.ylf.jdk8;

public class Test3 {

    public static void main(String[] args) {

        TheInterface1 i1 = () -> {};
        System.out.println(i1.getClass().getInterfaces()[0]);

        TheInterface2 i2 = () -> {};
        System.out.println(i2.getClass().getInterfaces()[0]);

        /**
         * 表达式：() -> {}; 是没有意义的，只有在确定了上下文的前提下才有意义，上下文如上面代码中的 TheInterface1 i1 和 TheInterface2 i2
         */
    }
}

@FunctionalInterface
interface TheInterface1 {
    void test1();
}

@FunctionalInterface
interface TheInterface2 {
    void test2();
}