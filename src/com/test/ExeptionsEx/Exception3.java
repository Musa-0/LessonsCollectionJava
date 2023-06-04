package com.test.ExeptionsEx;

import javax.security.sasl.SaslClient;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exception3 {
    public static void main(String[] args) {
        //все исключения делятся на 2 типа
        // Checked Exception - Compile time exception (проверяемые, те которые вызываются во время компиляции программы)
        // Unexception Exception - Runtime exception(не проверяемые, те которые вызываются во время выполнения программы)
        //Checked это наши try catch throw итд. те что проверяются при компиляции
        File file = new File("lol");
        try {
            Scanner sc = new Scanner(file);//тут мы явно указываем об возможной ошибке и эту возможность видит джава и она нас заставляет создавать исключения
        } catch (FileNotFoundException e) {
            //throw new RuntimeException(e);
            System.out.println("lololoo");
        }
        //Unchecked это те случаи которые джава не может посчитать как за ошибку но во время выполнения обнаруживается что такое делать нельзя например
        //int a = 1/0;//на ноль делить нельзя но со стороны синтаксиса тут все верно и джава не может прикопаться а после компиляции джава поймет что так нельзя
   //Checked это исключительные случаи а не ошибки для которых надо создавать исключения
    // а Unchecked это ОШИБКИ которые надо на прямую исправлять в коде ещё пример такой ошибки Index Out Of Range (python)
        //эти ошибки можно обработать с помощью try catch но лучше просто исправить эти ошибки
        try {
            int[]arr = new int[2];
            System.out.println(arr[2]);//укажем индекс которого нет
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("NOOOOOOOOO");
        }
        }//Но лучше просто не делать программы с подобными ошибками
    }
