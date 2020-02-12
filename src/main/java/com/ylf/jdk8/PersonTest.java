package com.ylf.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class PersonTest {

    public static void main(String[] args) {

        Person person1 = new Person("zhangsan", 20);
        Person person2 = new Person("lisi", 30);
        Person person3 = new Person("wangwu", 40);

        List<Person> persons = Arrays.asList(person1, person2, person3);

        PersonTest personTest = new PersonTest();
        personTest.getPersonsByUsername("zhangsan", persons).forEach(person -> System.out.println(person.getUsername()));
        personTest.getPersonsByAge(25, persons).forEach(person -> System.out.println(person.getAge()));
    }

    // 筛选集合中名字为username的对象，然后组成新集合并返回
    public List<Person> getPersonsByUsername(String username, List<Person> persons) {
        // 应用流进行筛选条件的判断，filter方法的参数Predicate为函数式接口，其抽象函数为返回一个boolean值的方法
        return persons.stream().filter(person -> person.getUsername().equals("zhangsan")).collect(Collectors.toList());
    }

    // 筛选集合中年龄大于等于25的对象，然后组成新集合并返回
    public List<Person> getPersonsByAge(int age, List<Person> persons) {
        // 1 由两个参数最后返回一个结果知使用BiFunction，首先定义BiFunction
        BiFunction<Integer, List<Person>, List<Person>> biFunction = (ageOfPerson, personList) ->
            personList.stream().filter(person -> person.getAge() >= ageOfPerson).collect(Collectors.toList());

        // 2 应用定义的BiFunction
        return biFunction.apply(age, persons);
    }
}
