package com.test.animel;

public class Dog extends Animal implements Info{//наследуется от класса животных
    public String color;
    public Dog(String color,int id){
        super(id);
        this.color = color;
    }
    public Dog(){}
    public void bark(){//лаить могут лишь собаки
        System.out.println("i am BAAARk");

    }

    @Override
    public void ShowInfo() {
        System.out.println("Color " + color);
    }
}
