package com.test.animel;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Brown",50);
        dog.eat();//этот метод присущен всем  животным он из Animals
        dog.bark();//этот метод присущен лишь собакам
        dog.ShowInfo();//Метод из интерфейса

    }
}
