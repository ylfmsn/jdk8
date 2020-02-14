package com.ylf.jdk8.methodreference;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用， 类名::静态方法名 形式
 */
public class MethodReferenceTest {

    public String getString(Supplier<String> supplier) {
        return supplier.get() + "test";
    }

    public String getString2(String str, Function<String, String> function) {
        return function.apply(str);
    }

    public static void main(String[] args) {

        Student student1 = new Student("zhangsan", 66);
        Student student2 = new Student("lisi", 72);
        Student student3 = new Student("wangwu", 76);
        Student student4 = new Student("zhaoliu", 89);

        List<Student> list = Arrays.asList(student1, student2, student3, student4);
        List<Student> list1 = Arrays.asList(student1, student2, student3, student4);
        List<Student> list2 = Arrays.asList(student1, student2, student3, student4);
        // 按照分数对集合排序，list的sort方法是本地排序是对原有集合元素进行排序，不创建新的集合
        list.sort((stu1, stu2) -> Student.commpareStudentByScore(stu1, stu2));
        list.forEach(item -> System.out.println(item.getScore()));
        System.out.println("------------");
        /**
         * lambda表达式功能实现（如上Studeng.compareByScore(Stu1, stu2)）恰好有一个对应方法能完成同样是先，且该方法为静态方法，
         * 则可以用 类名::静态方法名 形式的方法引用
         */
        list1.sort(Student::commpareStudentByScore);
        list1.forEach(item -> System.out.println(item.getScore()));

        list2.sort(Student::compareStudentByName);
        list2.forEach(item -> System.out.println(item.getName()));

        System.out.println("------------");

        List<Student> list3 = Arrays.asList(student1, student2, student3, student4);
        List<Student> list4 = Arrays.asList(student1, student2, student3, student4);
        /**
         * 引用名::实例方法名
         */
        StudentComparetor studentComparetor = new StudentComparetor();
        list3.sort(studentComparetor::compareByScore);
        list3.forEach(item -> System.out.println(item.getScore()));
        list4.sort(studentComparetor::compareByName);
        list4.forEach(item -> System.out.println(item.getName()));

        System.out.println("------------");

        List<Student> list5 = Arrays.asList(student1, student2, student3, student4);
        List<Student> list6 = Arrays.asList(student1, student2, student3, student4);
        /**
         * 类名::实例方法名
         *
         * compareByScore方法是实例方法，必须是对象调用而不是类调用，
         * sort方法的lambda表达式的第一个参数调用的compareByScore，
         * lambda表达式的其余参数作为compareByScore方法的参数传递给该方法
         */
        list5.sort(Student::compareByScore);
        list5.forEach(item -> System.out.println(item.getScore()));
        list6.sort(Student::compareByName);
        list6.forEach(item -> System.out.println(item.getName()));

        List<String> cities = Arrays.asList("taiyuan", "XiAn", "xining", "wulumuqi");
        Collections.sort(cities, (city1, city2) -> city1.compareToIgnoreCase(city2));
        cities.forEach(item -> System.out.println(item));
        Collections.sort(cities, String::compareToIgnoreCase);
        cities.forEach(item -> System.out.println(item));

        System.out.println("------------");

        /**
         * 构造方法引用 类名::new
         */
        MethodReferenceTest methodReferenceTest = new MethodReferenceTest();
        System.out.println(methodReferenceTest.getString(String::new));
        System.out.println(methodReferenceTest.getString2("hello", String::new));

    }
}
