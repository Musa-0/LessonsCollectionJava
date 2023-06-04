package com.test.reflectionEx;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Ex2 {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Class employeeClass = Class.forName("com.test.reflectionEx.Employee");

        //создание объекта с помощью рефлексии

        //Employee e = (Employee) employeeClass.newInstance();//старый метод, для java до 11 версии но его можно исп в конструкторе

        Constructor<Employee> constructor1 = employeeClass.getConstructor();//берем конструктор без параметров
        Employee obj1 = constructor1.newInstance();//и создаем объект класса Employee через конструктор

        Constructor<Employee> constructor2 = employeeClass.getConstructor(int.class,String.class,String.class);
        //берем конструктор с параметрами
        Employee obj2 = constructor2.newInstance(5,"Musa", "IT");//и создаем объект класса Employee через конструктор передавая параметры

        //вызов метода через Class
        Method method = employeeClass.getMethod("setSalary", double.class);//создаем обхект класса Methd метода setSalary
        method.invoke(obj2,800.88);//Вызываем метод setSalary для объекта класса Employee (obj2)
        System.out.println(obj2.getSalary());
    }
}
