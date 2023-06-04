package com.test.animel;

public class Animal implements Info {//класс всех животных
    public int id;
    public Animal(int id){
        this.id = id;
    }
    public Animal(){}
    public void eat(){//характеристика любого животного
        System.out.println("I am eat");
    }
    public void sleep(){//характеристика для любого животного
        System.out.println("I am sleep");
    }

    @Override
    public void ShowInfo() {//взят из интерфейса Info переопределим его
        System.out.println("Id if "+this.id);
    }
}
