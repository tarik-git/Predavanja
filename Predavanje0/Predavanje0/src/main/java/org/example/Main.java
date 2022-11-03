package org.example;

import models.Student;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Student student = new Student(1111, 25,181.0, "Azur");
        Student student1 = new Student(1234, 24, 190.4, "Haris");
        Student student2 = new Student();

        student.printName();

        System.out.println("Student: " + student);
    }

}