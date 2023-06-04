package com.test.Practic.Generic_and_InnerClass;

import java.util.Objects;

//Создать класс User, содержащий private переменные login, password.
//Создать внутренний класс Query в классе User. Класс Query содержит метод printToLog(), который распечатывает на консоль сообщение о том что пользователь с таким то логином и паролем отправил запрос.
//Класс User, содержит метод createQuery(), в котором создается объект класса Query и вызывается метод printToLog().
//В методе main(): создать экземпляр класса User и вызвать метод createQuery(); создать экземпляр класса Query и вызвать метод printToLog() используя конструкцию user.new Query(); создать экземпляр класса Query и вызвать метод printToLog() используя конструкцию new User().new Query();
public class User {
    public static void main(String[] args) {
        User user1 = new User("Musa", "0504");
        user1.createQuery();
        User.Query query1 = user1. new Query();//один из вариантов создать объект вложенного Query класса
        query1.printToLog();

        User.Query query2 = new User("Hava","1206").new Query();//второй вариант создания
        query2.printToLog();
    }



    public User(String login, String password){
        this.login = login;
        this.password = password;
    }
    private String login, password;

    public class Query{//запросы могут создавать лишь юзеры
        public void printToLog(){
            System.out.println("Пользователь с логином "+ login + " и поролем " + password + " отправил запрос");
        }
    }
    public Query createQuery(){
        Query obj = new Query();
        obj.printToLog();
        return obj;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }
}
