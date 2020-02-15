package com.ylf.jdk8.stream;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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



    }
}
