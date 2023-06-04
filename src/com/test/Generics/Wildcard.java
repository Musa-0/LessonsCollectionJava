package com.test.Generics;

import com.test.animel.Animal;
import com.test.animel.Dog;

import java.util.ArrayList;
import java.util.List;
//Люббой объект в джаве наследуется от класса Object
public class Wildcard {
    public static void main(String[] args) {
        List<Double> list1 = new ArrayList<>();
        list1.add(3.4);
        list1.add(5.6);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(1);

        test(list1);//
        test(list2);//мы можем передать туда разные типы листов

        System.out.println(summ(list1));
        System.out.println(summ(list2));

        List<?> list = new ArrayList<String>();//Wildcard это какой-то неизвестный тип, и компилятор не может вставить String в лист типа которого он не знает
        //!!list.add("heloo");  //забавноо но так делать нельзя!, ибо в List<?> нельзя добавлять элементы с любым типом, такк ак есть вероятность того что этот элемент не подойдет для нашего ArrayList
        //коллекции с Wilcard запрещают изменять коллекцию, добавлять или изменять объекты, ибо есть вероятность что тип нового объекта не подойдет нам
    }
    public static void test(List<? extends Number> list){//ЗНАК ? оЗНАЧАЕТ ЧТО МЫ МОЖЕМ ПОЛОЭИТЬ ТУДА ОБЪЕКТ ЛЮБОГО КЛАССА НАСЛЕДОВАННОГО ОТ Number
        //и мы не можем вписать туда Object тип, от него же все наслееедуется, но нет, так делать нельзя, ибо с коллекциями так не работает см Subtyping.java, а просто переменные вполне можно
        System.out.println(list);

    }
    public static double summ(List<? extends Number> list){//или можно сумировать все элементы листа содержащего элементы наследники Number
        double summ=0;
        for (Number n: list){
            summ+=n.doubleValue();//переводим все в double так как double может содержать в себе все типы
        }
        return summ;//и возвращаем сумму всех элементов в типе double
    }
}

//    List<? extends Number> list = new ArrayList<Integer>();    //этот тип говорит что можно использовать лишь наслдеников Number
//    List<? super Number> list = new ArrayList<Object>();    // а этот говорит что можно использовать лишь родителей Number

