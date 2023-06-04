package com.test;

import com.test.animel.Animal;
import com.test.animel.Dog;

import java.util.ArrayList;
import java.util.List;

public class PreobrazClass {
    public static void main(String[] args) {
        //Dog наследуется от Animal
        Animal animal = new Dog("Musa",12);//восходящее преобразование Upcasting. оно делается неявно и оно валидно так как в Dog есть все от Animal. Animal родитель
        Dog d = new Dog();
        Animal a = d;//любая собака животное.
        //НО НЕ ЛЮБОЕ ЖИВОТНОЕ СОБАКА
        Dog d2 = (Dog)animal;//нисходящее преобразование Downcasting.  тут ммы должны явно указывать что хотим сделать объект животного собакой и это в нашем случае сработает но это не безопасно
        d2.bark();//оно не сработает так как метод bark есть лишь у собак



        List arr = new ArrayList();
        arr.add("LOLLOLLOLLOOOLOOLOLOLLOLLOLOOO");
        arr.add(5);
        System.out.println((String)arr.get(0) + (Integer) arr.get(1));//мы можем иметь список объектов которым можем потом присваивать разные типы
    }
}
