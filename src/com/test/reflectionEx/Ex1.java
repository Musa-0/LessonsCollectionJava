package com.test.reflectionEx;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Ex1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        //1 способ создания объекта Class
        Class employeeClass = Class.forName("com.test.reflectionEx.Employee");//объект класса Class, и этот объект
        //это и есть наш Employee.

        //2 способ создания объекта Class
        Class employeeClass2 = Employee.class;

        //3 способ создания объекта Class
        Employee employee = new Employee();
        Class employeeClass3 =  employee.getClass();

        //получим информацию класса employeeClass

        Field someField = employeeClass.getField("id");//возьмем поле id из объекта Employee, и передадим его объекту
        // класса Field(класс полей)
        System.out.println("Тип поля id = " + someField.getType() + " имя поля = " + someField.getName());//выведем тип этого поля
        System.out.println("-------------------------------");

        Field [] fields = employeeClass.getFields();//вернет массив всех public полей

        for (Field f: fields){
            System.out.println("Тип поля " + f.getName() + " = " + f.getType());//выведем имя PUBLIC поля и его тип
        }

        Field [] allfields = employeeClass.getDeclaredFields();//вернет массив всех полей, и private тоже
        System.out.println("-------------------------------");


        Method somemethod1 = employeeClass.getMethod("increaseSalary");//передаем метод increaseSalary объекту класса Method
        System.out.println("Возвращаемый тип метода increaseSalary = " + somemethod1.getReturnType() +
                ", тип параметра = " + Arrays.toString(somemethod1.getParameterTypes()));//выведем тип возвращаемого значения метода
        //а так же, массив параметров этого метода

        Method somemethod2 = employeeClass.getMethod("setSalary", double.class);//передаем метод setSalary объекту класса
        //Method, указывая его параметры, чтобы джава нашла именно тот метод, что с одним параметром типа double, перегрузку никто не отменял

        System.out.println("Возвращаемый тип метода setSalary = " + somemethod2.getReturnType() +
                ", тип параметра = " + Arrays.toString(somemethod2.getParameterTypes()));
        System.out.println("------------------------------");

        Method [] methods = employeeClass.getMethods();//вернет массив public методов объекта Employee, и его родителя Objects

        for (Method m: methods){
            System.out.println("Имя метода = " + m.getName() +
                    " Возвращаемый тип метода = " + m.getReturnType() +
                    ", тип параметра = " + Arrays.toString(m.getParameterTypes()));
        }
        System.out.println("------------------------------");

        Method [] methods2 = employeeClass.getDeclaredMethods();//вернет все методы, и даже private. но не выведет методы класса
        // родителя Objects, только если метод не переопределен

        //выведем все public поля именно класса Employee а не класса Object, для этого можно исп getDeclaredMethods но с условием
        for (Method m: methods2){
            if (Modifier.isPublic(m.getModifiers()))//если модификация public в этом методе то вывести
            System.out.println("Имя метода = " + m.getName() +
                    " Возвращаемый тип метода = " + m.getReturnType() +
                    ", тип параметра = " + Arrays.toString(m.getParameterTypes()));
        }
        System.out.println("------------------------------");

        //конструкторы
        Constructor constructor = employeeClass.getConstructor();//получим данные конструктора без переметров
        System.out.println("Конструктор имеет " + constructor.getParameterCount() +
                " параметров, их тип = " + Arrays.toString(constructor.getTypeParameters()));
        System.out.println("------------------------------");

        Constructor constructor2 = employeeClass.getConstructor(int.class, String.class, String.class);
        //получим данные конструктора с параметрами
        System.out.println("Конструктор имеет " + constructor2.getParameterCount() +
                " параметров, их тип = " + Arrays.toString(constructor2.getParameterTypes()));
        System.out.println("------------------------------");

        Constructor [] constructors = employeeClass.getConstructors();
        for (Constructor c: constructors){
            System.out.println("Имя конструктора " + c.getName() +
                    " Конструктор имеет " + c.getParameterCount() +
                    " параметров, их тип = " + Arrays.toString(c.getParameterTypes()));
        }
    }
}
