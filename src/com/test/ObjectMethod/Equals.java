package com.test.ObjectMethod;

public class Equals {
    public static void main(String[] args) {
        //сравнение объектов между собой
        //сравнивать примитивы легко int a =3; a==b итд
        Animal animal = new Animal(1);
        Animal animal2 = new Animal(1);
        System.out.println(animal==animal2);//false потому что == сравнивает ссылки на объекты и оно работает лишь с примитивными типами данных но н ес сылочными
        //чтобы сравнивать объекты по их структуре а не по ссылкам на данные есть метод equals
        //Object object = new Object();
        //object.equals();

        //String str = "lol";//другая тема тут используется PoolString который даёт этой переменной ссылку на память с этой строкой и не надо создавать каждый раз новый объект.

        //System.out.println(animal.equals(animal2));//вызовит тот же false так как он так же сравнивает сылки
        //чтобы сравнивать данные по структуре надо переопределить метод equals
        System.out.println(animal.equals(animal2));//сравниваем объекты используя переопределенный метод equals
    }
}
class Animal{
    private int id;
    public boolean equals(Object obj) {//используем класс Object потму что он используется в классе родителе Object и надо указывать аргументы такие же как и там
        //пусть они будут равны если их id будут равны
        Animal other = (Animal) obj;//а тут мы сделаем этот объект типа Animal Downcasting переобразование и передаваемый объект должен быть или Animal или его наследники
        return this.id == other.id;//сравниваем их id
    }
    public Animal(int id){
        this.id = id;
    }
}