package com.test.animel;

class Animals {
    public void eat(){
        System.out.println("Animal is eat");
    }
}
interface Sleep{
    public void sleep();
}
public class Anonim {
    public static void main(String[] args) {
        Animals animals = new Animals();
        animals.eat();
        //Допустим мы хотим переопределить метод eat для этого мы можем создать новый класс в котором переопределим этот метод
        //но что если нам надо его переопределить всего один раз, для этого не стоит создавать новый класс можно просто воспользоваться анонимным классом
        Animals animals1 = new Animals() {//вот наш новый объект в котором переопределён нужный нам метод
            public void eat() {
                System.out.print("Other ashole");
            }
        };
        animals1.eat();
        //или с интерфейсом
        Sleep animal_sleep = new Sleep() {//тут мы сразу реализовываем интерфейсс так как нам нужно и таких классов от интерфейсов можно сделать много на разные случаи
            @Override
            public void sleep() {

            }
        };
    }
}
