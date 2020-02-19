package com.ylf.jdk8.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 分组与分区
 */
public class StreamTest13 {

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 100, 20);
        Student student2 = new Student("lisi", 90, 20);
        Student student3 = new Student("wangwu", 90, 30);
        Student student4 = new Student("zhangsan", 80, 40);

        // 按名字对list进行分组
        List<Student> students = Arrays.asList(student1, student2, student3, student4);
        // select * from student group by name;
        //Map<String, List<Student>> map = students.stream().collect(Collectors.groupingBy(student -> student.getName()));
        //Map<String, List<Student>> map = students.stream().collect(Collectors.groupingBy(Student::getName));

        // select name, count(*) from student group by name;
        //Map<String, Long> map = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));

        // 按名字分组后对每组的成绩求平均值
        //Map<String, Double> map = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));

        // 分区是分组的一种特例，只能分两组，符合条件的为一组，剩下的为一组
        // 按照分数大于等于 或者 小于90分进行分区
        Map<Boolean, List<Student>> map = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() >= 90));

        System.out.println(map);

        // 获取大于等于90分的
        //map.get(true);
    }
}
