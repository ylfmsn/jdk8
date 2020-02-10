package com.ylf.jdk8;

@FunctionalInterface
interface MyInterface {
    void test();

    @Override
    String toString();
}

public class Test2 {

    public void myTest(MyInterface myInterface) {
        System.out.println(1);
        myInterface.test();
        System.out.println(2);
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();

        /**
         * lambda表达式针对的是函数式接口，函数式接口只有一个抽象方法test(),该方法不接收参数
         */
        test2.myTest(() -> {
            System.out.println("mytest");
        });

        System.out.println("-------------------------");

        MyInterface myInterface = () -> {
            System.out.println("hello");
        };

        System.out.println(myInterface.getClass());
        System.out.println(myInterface.getClass().getSuperclass());
        System.out.println(myInterface.getClass().getInterfaces()[0]);
    }
}
