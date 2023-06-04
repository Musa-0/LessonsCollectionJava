package com.test.annotationEx;

//Аннотации - это специальные метки, методанные. Которые нужны для передачи определенной информации
//её можно использовать для указания иформации о данных. например при работе с бд, у нас есть поле класса, а чтобы указать то
//какой калонкой будет это поле в бд, мы можем использовать аннотацию куда передадим имя колонки к которой предназначено это поле

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//Создадим свою аннотацию

@Target({ElementType.METHOD, ElementType.TYPE})//говорим что эта аннотация может быть использованна лишь к методу и классу
@Retention(RetentionPolicy.RUNTIME)//описывает жизненный цикл аннотации, говоря о том когда она должна исчезнуть
//SOURCE - Аннотация вида в source коде, отбрасывается компилятором и уже в byte коде не видна - дефолтный
//CLASS - Аннотация видна в byte коде, отбрасывается JVM во время выполнения программы
//RUNTIME - Аннотация видна во время выполнения программы
@interface MyAnnotation{//создаем аннотацию

}

public class Employee {
    String name;
    Double salary;


    public void increaseSalary(){
        salary*=2;//увеличиваем зп в двоя
    }

    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

