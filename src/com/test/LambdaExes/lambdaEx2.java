package com.test.LambdaExes;

import java.util.ArrayList;
import java.util.Collections;

//lambda это как анонимный класс но АНОНИМНАЯ ФУНКЦИЯ
//lambda работает только с интерфейсами
public class lambdaEx2 {
    static void def(I i){//функция которая выводит то что вернёт функция
        System.out.println(i.abc("privet"));
    }

    public static void main(String[] args) {
        def((String str) -> {return str.length();});//lambda выражение которое берет метод abc из интерфейса I
        // и переопределяет его, как анонимный класс но это АНОНИМНАЯ ФУНКЦИЯ которая переопределяет функцию в интерфейсе
        // если нет параметра то пишете пустые скобки ()
        int i = 10;
        I sc = (String str) -> {
            System.out.println(i);
            return str.length()*i;//В ЛЯМДАХ ВЫРАЖЕНИЯХ МОЖНО ИСПОЛЬЗОВАТЬ ПЕРЕМЕННЫЕ ИЗ ВНЕ ТОЛЬКО ЕСЛИ ОНИ КОНСТАНТНЫЕ, ИЛИ ИХ ПРОСТО НЕ МЕНЯЮТ
        };//это лямда выражение можно присваивать переменной
        def(sc);


        //КРУТОЙ ПРИМЕР
        Student st1 = new Student("Musa",'m',17,2,5.3);
        Student st2 = new Student("Hava",'w',18,4,6.2);
        Student st3 = new Student("Amina",'w',19,3,4.1);
        ArrayList<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        Collections.sort(students, (stud1, stud2) -> {return stud1.course-stud2.course;});//Нам не нужно писать отдельный анонимный класс
        // и переопределять метод compare для определения какой объект больше можно просто написать лямбда выражение в которой указать по какому именно критерию сравнивать объекты
        System.out.println(students);
    }
}
interface I{//интерфейс который прописывает метод возвращающий int а сам метод мы пропишем в нашей lambda
    int abc(String s);

}//такие интерфесы называют функцианальными
