package com.ylf.jdk8.methodreference;

public class StudentComparetor {

    public int compareByScore(Student student1, Student student2) {
        return student1.getScore() - student2.getScore();
    }

    public int compareByName(Student student1, Student student2) {
        return student1.getName().compareToIgnoreCase(student2.getName());
    }
}
