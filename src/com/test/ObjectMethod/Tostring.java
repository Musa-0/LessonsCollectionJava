package com.test.ObjectMethod;

public class Tostring {
    public static void main(String[] args) {
        Human h1 = new Human("Musa",17);//создаём оъект класса который мы взяли из файла Main
        System.out.println(h1.toString());//выведет имя нашего объекта (Имя класса@Хэш код объекта)


    }
}
class Human{
    private String name;
    private int age;
    public String toString(){//Переопределим базовый метод класса Object и сделаем так чтоюы имя объекта было поле name этого объекта
        return this.name;

    }
    public Human(String name, int age){
        this.age = age;
        this.name = name;


    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public void setName(String name)
    {
        this.name = name;
    }

}