package com.ylf.jdk8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest4 {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("hello", "world", "helloworld");

        //String[] stringArray = stream.toArray(length -> new String[length]);   // lambda表达式
        // 方法引用
        String[] stringArray = stream.toArray(String[]::new);

        Arrays.asList(stringArray).forEach(System.out::println);
        System.out.println("------------");

        Stream<String> stream1 = Stream.of("hello", "world", "helloworld");
        //List<String> list = stream1.collect(Collectors.toList());
        //List<String> list = stream1.collect(() -> new ArrayList<String>(), (theList, item) -> theList.add(item), (theList1, theList2) -> theList1.addAll(theList2));
        List<String> list = stream1.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        list.forEach(System.out::println);

        System.out.println("------------");

        Stream<String> stream2 = Stream.of("hello", "world", "helloworld");
        Set<String> set = stream2.collect(Collectors.toCollection(TreeSet::new));
        set.forEach(System.out::println);

        System.out.println("------------");

        Stream<String> stream3 = Stream.of("hello", "world", "helloworld");
        String str = stream3.collect(Collectors.joining());
        System.out.println(str);


    }
}
