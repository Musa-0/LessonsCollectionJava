package com.test.Generics;

import java.util.ArrayList;

public class ParameterizedMethodEx {
    public static void main(String[] args) {


        ArrayList<Integer> al1 = new ArrayList<>();//мы можем выбрать любой тип
        al1.add(10);
        al1.add(20);
        al1.add(30);
        int a = GenMethod.getSecondElement(al1);//и тут мы достаем первый элемент этого массива не в зависимости от типа массива
        System.out.println(a);
    }
}

class GenMethod{
    public static <T> T getSecondElement(ArrayList<T> a1){//тут мы указываем <T> T говоря что тип возвращаемого объекта
        //будет T, и после чего возвращаем первый элемент массива, с любым типом данных
        return a1.get(0);
    }
}
