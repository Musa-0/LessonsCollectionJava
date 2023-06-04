package com.test.animel;

//Интерфейс это то что умеет делать класс. тут нельзя делать один функционал на несколько объектов у каждого реализация по разному
// Абстрактный класс это то кем является класс наследник. тут можно делать общий функционал для всех объектов например метод eat присущий всем животным
public class Abstract{
public static void main(String[]args){
        Tiger t = new Tiger();
        Hourse h = new Hourse();
        t.eat();//все животные едят
        h.eat();//все животные едят
        t.Sound();//только тигр рычит
        h.Sound();//только лошадь игогошет
}
}
abstract class Animalss {//Абстрактный класс животных
    //у него не может быть своих объектов он может лишь наследовать
    public void eat(){// животные едят
        System.out.println("EAT");
    }
    public abstract void Sound();//это абстрактный метод и в каждом классе наследнике будет своя реализация так как все животные говорят по разному
}
class Tiger extends Animalss{//наследуемся от Abstract
    @Override
    public void Sound() {//тут мы реализуем абстрактный метод из класса родителя
        System.out.println("PPPPPPP");//тигр говорит так
    }
}
class Hourse extends Animalss{
    @Override
    public void Sound(){//реализуем метод звучания лошади
        System.out.println("IGOGOGOOO");//лощадь говорит так
    }
}