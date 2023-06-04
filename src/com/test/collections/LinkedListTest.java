package com.test.collections;

import java.util.LinkedList;
import java.util.List;

//LinkedList это список на основе связанных элементов а не массива. и тут процесс добавления или удаления на много быстрее
public class LinkedListTest {
    public static void main(String[] args) {
    Students st1 = new Students(1,"Musa1");
    Students st2 = new Students(2,"Musa2");
    List<Students> students = new LinkedList<>();
    students.add(st1);
    students.add(st2);
    System.out.println(students);
//если у нас много данных и мы часто что-то добавлям или удаляем то используй LinkedList
}
}

class Students{
    int age;
    String name;
    public Students(int age,String name){
        this.name = name;
        this.age = age;
    }
}