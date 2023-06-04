package com.test.Generics.Game_Olimp;

public abstract class Partisepant {//класс участников. абстрактный так как не может быть участника, без статуса

    private String name;
    private Integer age;

    Partisepant(String name, Integer age){
        this.name = name;
        this.age = age;

    }

}
