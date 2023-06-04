package com.test.Generics.Game_Olimp;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team<T extends Partisepant> {//класс команд, где T это тип команды, который должен наследоваться
//от класса участников(Partisepant), Школьники студенты итд, не могут быть учасники разных статусов в одной команде
    String name;
    List<T> list_partesepant = new ArrayList<>();//тут создается лист участников, в которой могут быть лишь участники типа T что указан в этой команде

    public Team(String name) {
        this.name = name;
    }
    public void addParticepent(T p){
        list_partesepant.add(p);
    }
    public void gameWith(Team<T> team){//метод, игры одной команды с другой, другая команда, должна быть того же типа
        // что и у той у которой вызываем, школьники со школьниками, студенты со студентами, работники с работниками
        Integer winer = new Random().nextInt(2);//берем рандом, от 0 до 1
        if(winer==0){
            System.out.println("выиграла команда " + this.name);
        }
        else{
            System.out.println("выиграла команда " + team.name);
    }}
}
