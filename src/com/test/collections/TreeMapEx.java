package com.test.collections;

import java.util.TreeMap;

public class TreeMapEx {
    //TreMap - это словарь на основе бинарного дерева, элементы которого хронятся по возрастанию
    public static void main(String[] args) {
        TreeMap<Integer, Student> treemap = new TreeMap<>();
        Student st1 = new Student(1,"Musa", "Haniev", 1);
        Student st2 = new Student(2,"Hava", "Hanieva", 3);
        Student st3 = new Student(3,"Amina", "Hanieva", 4);
        treemap.put(5, st1);
        treemap.put(6, st2);
        treemap.put(3, st3);
        System.out.println(treemap);//будет словарь отсортированный по ключу
        System.out.println(treemap.descendingMap());//выводит не по возрастанию а по убыванию
        System.out.println(treemap.tailMap(4));//выводит все элементы чьи ключи больше или равно 4
        System.out.println(treemap.headMap(4));//выводит все элементы чьи ключи меньше 4
        System.out.println(treemap.lastEntry());//последний элемент больший ключ
        System.out.println(treemap.firstEntry());//первый элемент меньший ключ

        TreeMap<Student, Integer> treemap2 = new TreeMap<>();
        treemap2.put(st1,3);
        treemap2.put(st2,4);
        treemap2.put(st3,1);
        System.out.println(treemap2);//будет сортироваться по нашим обектам.А ТЕ в свою очередь будут сравниваться по методу Compare который мы прописали в классе Students

    }
}
