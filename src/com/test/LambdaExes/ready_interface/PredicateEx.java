package com.test.LambdaExes.ready_interface;
import com.test.LambdaExes.lambdaEx;

import java.util.ArrayList;
import java.util.function.Predicate;


//Predicate это готовый преметизованный интерфейс, который, имеет один метод,
//        boolean test(T t); - который принимает в себя объект любого класса, и возвращает True или False,
//        его можно использовать при Lambda выражениях, вместо того чтобы писать свой


public class PredicateEx {

    void testStudent(ArrayList<Student> st, Predicate<Student> pr){//в Predicate мы передадим нашу лямбду функцию, которая в результате вернет true или false
        for(Student s:st){
            if(pr.test(s)){
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
        PredicateEx info = new PredicateEx();
        info.testStudent(students, (Student p) -> {
            return p.age<=18;
        });
                                        //Predicate часто используется с методом коллекции removeIf,
                                        // а именно, она делает условие удаление тех элементов, что под неё не подходят

        System.out.println('\n');

        students.removeIf(el -> el.course>3);//этот метод удалит все элемент у которых курс больше 3
        System.out.println(students);

        //можно вывести это в отдельную переменную
        Predicate<Student> p = element -> element.name.length()>4;//этот объект имеет условие, все елементы имя которых больше 4
        students.removeIf(p);//удалит те элементы у которых имя больше чем из 4 букв
        System.out.println(students);

//а можно и совместить students.removeIf(p.and(p2)); - тут у нас используется условие p и условие p2(которое можно создать)
//students.removeIf(p.or(p2)); - тут у нас используется условие p или условие p2(которое можно создать)

    }


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