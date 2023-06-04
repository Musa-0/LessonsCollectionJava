package com.test.Practic.Generic_and_InnerClass;

import java.util.Objects;
//тоже самое что и в файле User, но используем вложеный класс, static
public class User_stat {
    public static void main(String[] args) {
        initialize("Musa", "0504");
        User_stat.Query query1 = new User_stat.Query();
        query1.printToLog();
    }


    public static void initialize(String login, String password) {
        User_stat.login = login;
        User_stat.password = password;
    }

    private static String login, password;

    public static class Query {//запросы могут создавать лишь юзеры

        public void printToLog() {
            System.out.println("Пользователь с логином " + login + " и поролем " + password + " отправил запрос");
        }
    }
}

