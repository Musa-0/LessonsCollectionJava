package com.test.collections;

import java.util.*;

public class ArrayListEx {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(20);//массив динамический. но 20 это у нас начальная
        // вместимость, чтобы потом массиву не пришлось увеличиватья ибо это очень затратно
        list.add("Hello");
        list.add(0, "Amigo");

        ArrayList<String> secondList = new ArrayList<>(list);//делаем копию нашего list
        list.addAll(secondList);//добавляет все из массива secondList  в наш list
        list.addAll(1,secondList);//тоже самое но с указанием индекса куда класть

        ArrayList<String> copyOfSecondList = (ArrayList<String>) secondList.clone();//создает копию массива
        secondList.clear();//очищает массик=в

        Boolean b = copyOfSecondList.contains("Hello");//проверяет на содержание элемента по значению

        Boolean b_all = copyOfSecondList.containsAll(list);//имеет ли массив copyOfSecondList все элементы массива list

        list.get(0);//берет элемент по индексу

        list.indexOf("Hello");//берет индекс по значению
        list.lastIndexOf("Hello");//берет индекс по значению но начиная с конца

        list.isEmpty();//проверяет массив на пустоту

        list.iterator();//делает итератор из массива

        List<String> list2 = list.subList(1,4);//берет из списка list все значения от одного до 4 не включительно
        //но он не создает отдельный новый список, он лишь показывает эту часть, это как представление view для массива

        ArrayList<Integer> list_dig = new ArrayList<>();
        list_dig.add(4);
        list_dig.remove(Integer.valueOf(4));//удаляет по значению
        list.remove(3);//удаляет по индексу

        list.removeAll(secondList);//удаляет все перечесения list с secondList

        list.retainAll(secondList);//наоборот, оставит все совпадения. а все не совпадения удалит

        list.size();//смотрит размер

        list.set(3,"lol shabaton");//замена элемента по индексу 3 на значение "lol shabaton"

        Collections.sort(list);//сортировка по возрастанию
        Collections.reverse(list);//переворачивает список

        String[] array = new String[secondList.size()];
        secondList.toArray(array);//делает из динамического массива статический

        Integer[] arr = {1,2,3};
        List<Integer> arr_to_list = Arrays.asList(arr);//делает из массива List
    }
}
