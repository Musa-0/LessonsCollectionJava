package com.test.reflectionEx;

import java.lang.reflect.Field;
import java.nio.file.Files;

public class Ex3 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Employee employee = new Employee(3,"Hava", "HR");//создадим объект класса Employee

        Class emp = employee.getClass();//Создадим объект класса Class для Employee

        Field field = emp.getDeclaredField("salary");//возьмем privae поле salary

        field.setAccessible(true);//Даем себе доступ на значение поля salary так как оно private,

        field.set(employee, 1500);//получив доступ, изменим значение поля salary

        Double salaryValue = (Double) field.get(employee);//а теперь возьмем поле salary у объекта emp

        System.out.println(salaryValue);
    }
}
