package com.example.task1spring.DB;
import java.util.ArrayList;

public class DBManager {
    private static ArrayList<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1L,"Adil","Token",95,"A"));
    }

    public static ArrayList<Student> getStudents(){
        return students;
    }

    public static void addStudent(Student student){
        students.add(student);
    }

}