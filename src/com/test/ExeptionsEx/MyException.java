package com.test.ExeptionsEx;

public class MyException extends Exception{//наследуемся от базового класса исключений
    //Создадим свое исключение
    public MyException(){}
    public MyException(String desc){//конструктор который выводит текст который мы передадим
        super(desc);
    }
}
