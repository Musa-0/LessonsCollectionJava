package com.test.LambdaExes;

import java.util.ArrayList;
//lambda это как анонимный класс но АНОНИМНАЯ ФУНКЦИЯ
//lambda работает только с интерфейсами

public class lambdaEx {
    void testStudent(ArrayList<Student> st, StudentChecks sc){
        for(Student s:st){
            if(sc.check(s)){
                System.out.println(s);
            }
        }
    }
    public static void main(String[] args) {
    Student st1 = new Student("Musa",'m',17,2,5.3);
    Student st2 = new Student("Hava",'w',18,4,6.2);
    Student st3 = new Student("Amina",'w',19,3,4.1);
    ArrayList<Student> students = new ArrayList<>();
    students.add(st1);
    students.add(st2);
    students.add(st3);
    lambdaEx info = new lambdaEx();
    info.testStudent(students, (Student s) -> {return s.age<=18;});//во второй аргумент передается lambda выражение которое создаёт анонимный класс
        // переопределяющий метод check интерфейса StudentChecks он должен быть всего один чтобы джава знала какой метод брать, в качестве аргумента
        // передает объект Student как и в методе и ряяядом пишет тело этого метода
    }


}

interface StudentChecks{//интерфейс для проверки студентов
    boolean check(Student s);
}
class Student
{
    String name;
    char gender;
    int age;
    int course;
    double mark;

    public Student(String name, char gender, int age, int course, double mark) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.course = course;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", course=" + course +
                ", mark=" + mark +
                '}';
    }
}