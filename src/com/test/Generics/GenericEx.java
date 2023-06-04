package com.test.Generics;

import java.util.ArrayList;
import java.util.List;

//Generic нужен для того чтобы указывать при создании коллекции то какой тип элемента он будет в себе хранить
public class GenericEx {
    public static void main(String[] args) {


        List list = new ArrayList();//тут может быть любой тип объекта, то есть все классы наследники Objects
        list.add("privet");
        list.add("hiiii");
        list.add("lol");//наполним его объектами класса String

        for(Object o: list){//тут мы должны будет обходить массив, где o будет типа Objects так как мы не знаем какой тип
            // объектов задан в коллекции
            System.out.println(o + "dlina" + ((String)o).length());//и тут мы уже конвертируем её в String
        }
        //так делать нельзя надо использовать Generic
        List<String> list2 = new ArrayList<>();//теперь здесь будет лишь объекты класса String

    }
}
