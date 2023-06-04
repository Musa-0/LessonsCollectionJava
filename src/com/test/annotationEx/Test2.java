package com.test.annotationEx;

import java.lang.annotation.*;

public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException {

        Class xiaomiClass = Class.forName("com.test.annotationEx.Xiaomi");//берем класс Xiaomi и присваиваем
        Annotation annotation1 = xiaomiClass.getAnnotation(SmartPhone.class);
        SmartPhone sm1 = (SmartPhone) annotation1;//создадим смартфон аннотацию
        System.out.println("Annotation info from Xiaomi class" + sm1.OS() + ", " + sm1.yearOfCompanyCreation());

        Class iphoneClass = Class.forName("com.test.annotationEx.Iphone");//берем класс Iphone и присваиваем
        Annotation annotation2 = iphoneClass.getAnnotation(SmartPhone.class);
        SmartPhone sm2 = (SmartPhone) annotation2;//создадим айфон аннотацию
        System.out.println("Annotation info from Iphone class" + sm2.OS() + ", " + sm2.yearOfCompanyCreation());

    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone{//анотация смартфона
    String OS() default "Android";//ос смартфона, так же указываем дефолтные значения
    int yearOfCompanyCreation();//год создания компании этих смартфонов
    //НЕЛЬЗЯ ИСПОЛЬЗОВАТЬ ССЫЛОЧНЫЕ ТИПЫ ДАННЫХ, String это исключение
}

@SmartPhone(yearOfCompanyCreation = 1994)//указываем поля аннотации, словно аргументы метода, теперь это методанные Xiaomi
class Xiaomi{
    String model;
    double price;
}

@SmartPhone(OS = "IOS", yearOfCompanyCreation = 1978)//указываем поля аннотации, словно аргументы метода, теперь это методанные Xiaomi
class Iphone{
    String model;
    double price;
}