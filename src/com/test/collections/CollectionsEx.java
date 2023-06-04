package com.test.collections;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsEx {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(1);
        Collections.shuffle(list);//перемешивает элементы листа
        Collections.sort(list);//сортирует данные по возрастанию
        Collections.reverse(list);//сортирует данные по убыванию
        int index = Collections.binarySearch(list, 3);//делает бинарный поиск
        System.out.println(index);
    }
}
