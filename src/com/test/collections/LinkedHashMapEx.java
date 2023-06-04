package com.test.collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapEx {
    //наследник HashMap отличие этого словаря от обычного в том что он помнит информацию о добавлении и использовании элементов, производительность методов чуть ниже чем у обычного словаря
    // элемент LinkedHashMap помимо того что содержит простой HashMap так же содержит ссылки на пред. и след. элементы
    public static void main(String[] args) {
        Map<Integer,Student> linkedhashmap = new LinkedHashMap<>(16, 0.75f, true);//что именно означают первые два аргумента смотри в файле HashMapEx. А третьий элемень говорит о том как мы хотим хранить элементы. по использованию элементов (get, remove) - true. или созданию элементов (put) - false
        Student st1 = new Student(1,"Musa", "Haniev", 1);
        Student st2 = new Student(2,"Hava", "Hanieva", 3);
        Student st3 = new Student(3,"Amina", "Hanieva", 4);
        linkedhashmap.put(3,st1);
        linkedhashmap.put(5,st3);
        linkedhashmap.put(2,st2);
        //если у нас сортировка по использованию элементов то тот элемент который мы например просмотрели с помощью get становится в конец
        linkedhashmap.get(5);
        System.out.println(linkedhashmap);//выведится в том порядке в каком мы его и добавили
    }
}
