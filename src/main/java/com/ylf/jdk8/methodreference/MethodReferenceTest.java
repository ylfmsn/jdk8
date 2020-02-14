package com.ylf.jdk8.methodreference;

import java.util.Arrays;
import java.util.List;

/**
 * 方法引用， 类名::静态方法名 形式
 */
public class MethodReferenceTest {

    public static void main(String[] args) {

        Student student1 = new Student("zhangsan", 66);
        Student student2 = new Student("lisi", 72);
        Student student3 = new Student("wangwu", 76);
        Student student4 = new Student("zhaoliu", 89);

        List<Student> list = Arrays.asList(student1, student2, student3, student4);
        List<Student> list1 = Arrays.asList(student1, student2, student3, student4);
        // 按照分数对集合排序，list的sort方法是本地排序是对原有集合元素进行排序，不创建新的集合
        list.sort((stu1, stu2) -> Student.commpareByScore(stu1, stu2));
        list.forEach(item -> System.out.println(item.getScore()));
        System.out.println("------------");
        /**
         * lambda表达式功能实现（如上Studeng.compareByScore(Stu1, stu2)）恰好有一个对应方法能完成同样是先，且该方法为静态方法，
         * 则可以用 类名::静态方法名 形式的方法引用
         */
        list1.sort(Student::commpareByScore);
        list1.forEach(item -> System.out.println(item.getScore()));







    }




}
