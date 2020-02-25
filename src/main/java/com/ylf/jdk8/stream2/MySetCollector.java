package com.ylf.jdk8.stream2;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * 自定义一个Collector收集器，
 * T表示要处理的流中要素的类型，
 * 第一个Set<T>表示定义的容器类型，
 *  最后一个Set<T>为最终要生成的容器的类型
 * @param <T>
 */
public class MySetCollector<T> implements Collector<T, Set<T>, Set<T>> {

    // 用于生成处理流中要素的容器，最终返回的HashSet对象，就是要被accumulator方法调用的空的结果容器
    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("suppier invoked!");
        return HashSet::new;
    }

    // 累加器，BiConsumer接收两个参数，不返回类型，
    // 第一个参数表示自定义的空的容器，第二个参数表示要处理的流中的下一个元素，即将元素处理到新定义的容器中
    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoked!");
        // 此处只能用Set<T>::add, 不能使用HashSet<T>::add,因为无法确定supplier方法返回的set集合的具体类型，可能HashSet 可能TreeSet。。。
        return Set<T>::add;
    }

    // 用于将并行流，多个线程执行的部分结果给合并起来，所以会接收两个相同类型的中间结果，
    // 中间结果都是Set<T>类型，然后把一个部分结果添加到另外一个部分结果中
    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoked!");
        return (set1, set2) -> {
            set1.addAll(set2);
            return set1;
        };
    }

    // 可选的，如果中间定义的容器类型跟最终返回的类型一致的话，该方法可以不用编写，返回一个最终的结果类型
    @Override
    public Function<Set<T>, Set<T>> finisher() {
        System.out.println("finisher invoked!");
        // return t -> t;  // 等价于下面的Function的静态方法identity
        return Function.identity();
    }

    // 收集器的属性，用于优化汇聚操作的实现，一个枚举，有三个值：CONCURRENT， IDENTITY_FINISH， UNORDERED
    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoked!");
        // 如果认为中间容器类型跟最终结果类型一样，
        // 可以将Characteristics设置为IDENTITY_FINISH，
        // 程序会强制将中间类型转换为结果类型，这时要确保强制转换可以成功，程序不会执行finisher方法
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.UNORDERED));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "welcome");
        Set<String> set = list.stream().collect(new MySetCollector<>());

        System.out.println(set);
    }
}
