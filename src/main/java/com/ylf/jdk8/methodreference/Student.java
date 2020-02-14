package com.ylf.jdk8.methodreference;

public class Student {

    private String name;

    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    /**
     * 方法引用中的 类::静态方法 形式
     */
    // 根据分数排序，正序
    public static int commpareStudentByScore(Student student1, Student student2) {
        return student1.getScore() - student2.getScore();
    }

    // 根据名字的ASIIC码值排序
    public static int compareStudentByName(Student student1, Student student2) {
        return student1.getName().compareToIgnoreCase(student2.getName());
    }

    /**
     * 类名::实例方法名
     */
    public int compareByScore(Student student) {
        return this.getScore() - student.getScore();
    }

    public int compareByName(Student student) {
        return this.getName().compareToIgnoreCase(student.getName());
    }
}
