package com.test.reflectionEx;

import com.test.FileRead;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//пример использования рефлексии
//её соль в том, что мы руками прописываем код во время выполнения программы, и это очень полезно, ибо мы можем писать код, во время
//выполнения
public class Calculator {
    void sum(int a, int b){//сложение
        int res = a+b;
        System.out.println("Сумма " + a + " и " + b + " = " + res);
    }

    void substraction(int a, int b){//вычитание
        int res = a-b;
        System.out.println("Разность " + a + " и " + b + " = " + res);
    }

    void multiplication(int a, int b){//умножение
        int res = a*b;
        System.out.println("Произведение " + a + " и " + b + " = " + res);
    }

    void division(int a, int b){//деление
        int res = a/b;
        System.out.println("Частное " + a + " и " + b + " = " + res);
    }
}

class TestCalculator{
    public static void main(String[] args) {
        //возьмем файл, в котором прописана операция, и два параметра для этой операции
        try (BufferedReader reader = new BufferedReader(new FileReader("src/com/test/reflectionEx/colcul_test.txt"))){

            String methodName = reader.readLine();//читаем первую строку, а именно тип операции над числами
            String firstArg = reader.readLine();//читаем след строку с первым параметром на операцию
            String secondArg = reader.readLine();//читаем след строку со вторым параметром на операцию

            Calculator calculator = new Calculator();//создаем объект класса колькулятора
            Class cl = calculator.getClass();//и объекта класса Class

            Method method = null;//метод пока сделаем null

            Method[] methods = cl.getDeclaredMethods();//берем все методы именно этого класса, без методов класса родителя
            for(Method m: methods){
                if(m.getName().equals(methodName)){//сверяем, имя метода, и имя операции из файла
                    method = m;//если есть метод, имя которого такое же как и то что мы указали в файле. то присваиваем его нашему методу
                }
            }

            method.invoke(calculator, Integer.parseInt(firstArg), Integer.parseInt(secondArg));//вызываем метод, что мы нашли выше,
            //и выполняем его для объекта calculator с параметрами которые мы так же взяли из файла


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
