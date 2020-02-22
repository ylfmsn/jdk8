package com.ylf.jdk8.stream2;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamTest1 {

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 80);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 100);
        Student student4 = new Student("zhaoliu", 90);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        List<Student> students1 = students.stream().collect(toList());
        students1.forEach(System.out::println);
        System.out.println("--------------------");

        System.out.println("count: " + students.stream().collect(counting()));
        System.out.println("count: " + students.stream().count());
        System.out.println("--------------------");

        // 找出成绩最小值 最大值 平均值 总和 综述 打印
        students.stream().collect(minBy(Comparator.comparingInt(Student::getScore))).ifPresent(System.out::println);
        students.stream().collect(maxBy(Comparator.comparingInt(Student::getScore))).ifPresent(System.out::println);
        System.out.println(students.stream().collect(averagingInt(Student::getScore)));
        System.out.println(students.stream().collect(summingInt(Student::getScore)));
        IntSummaryStatistics intSummaryStatistics = students.stream().collect(summarizingInt(Student::getScore));
        System.out.println(intSummaryStatistics);
        System.out.println("--------------------");

        // 将名字用逗号隔开拼接成字符串打印
        System.out.println(students.stream().map(Student::getName).collect(joining(",")));
        // 将名字用逗号隔开拼接成字符串，并给字符串加上前缀 后缀 然后打印
        System.out.println(students.stream().map(Student::getName).collect(Collectors.joining(",", "<begin>", "<end>")));
        System.out.println("--------------------");

        // 先按照成绩分组返回Map<Integer, List<Student>>，再对返回的每一组按照名字进行分组，返回Map<Integer, Map<String, List<Student>>>
        Map<Integer, Map<String, List<Student>>> map = students.stream().collect(groupingBy(Student::getScore, groupingBy(Student::getName)));
        System.out.println(map);
        System.out.println("--------------------");

        // 按照成绩大于80对集合进行分区，返回Map<Boolean, List<Student>>
        Map<Boolean, List<Student>> map2 = students.stream().collect(partitioningBy(student -> student.getScore() > 80));
        System.out.println(map2);
        System.out.println("--------------------");

        // 先按照成绩大于80与否对集合进行分区，返回Map<Boolean, List<Student>>，然会对返回的每一区再按照成绩大于90与否进行分区，返回Map<Boolean, Map<Boolean, List<Student>>>
        Map<Boolean, Map<Boolean, List<Student>>> map3 = students.stream().collect(partitioningBy(student -> student.getScore() > 80, partitioningBy(student -> student.getScore() > 90)));
        System.out.println(map3);

        // 按照成绩大于80与否对集合进行分区返回Map<Boolean, List<Student>>，然后对每一区元素个数进行统计，返回Map<Boolean, Long>
        Map<Boolean, Long> map4 = students.stream().collect(partitioningBy(student -> student.getScore() > 80, counting()));
        System.out.println(map4);

        // 按照名字进行分组，分组的结果为每一组都有元素，然后对分组后的每一组进行查找，找到最小成绩的元素，返回Optional，然后获取元素
        Map<String, Student> map5 = students.stream().collect(groupingBy(Student::getName, collectingAndThen(minBy(Comparator.comparingInt(Student::getScore)), Optional::get)));
        System.out.println(map5);
    }
}
