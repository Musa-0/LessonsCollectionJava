package com.test.work_with_file.serializer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

//Таким образом мы можем получать такие объекты из интернета и открывать их
public class ReadObject {
    //читает объекты с файла
    public static void main(String[] args) throws IOException {
        //объекты для первого способа
        FileInputStream file = new FileInputStream("src/com/test/work_with_file/serializer/person_object");// создадим объект для чтения потока байт из файла
        ObjectInputStream oos = new ObjectInputStream(file);//класс для перевода из потока байт в объекты
        //объекты для второго способа
        FileInputStream file2 = new FileInputStream("src/com/test/work_with_file/serializer/person_object2");// создадим объект для чтения потока байт из файла
        ObjectInputStream oos2 = new ObjectInputStream(file2);//класс для перевода из потока байт в объекты
        //1 способ получения данных из файла объектов через массив
        try {

            int count = oos.readInt();//получаем колличество объектов
            Person[] people = new Person[count];//создаём массив с размером массива который будет нам передан через файл
            for(int i = 0; i<count;i++){
                people[i]=(Person)oos.readObject();// преобразуем из объекта в объект Person и положим в наш массив
            }
            System.out.println(Arrays.toString(people));//выведем массив
            oos.close();
        } catch (ClassNotFoundException e) {//на случай если такого класса нет по каким либо причинам. например запуск этого файла на другом устройстве
            throw new RuntimeException(e);
        }
        //2 способ получения данных это получение массива целиком а не по объектам, перебирая их через for
        try {
            Person[] people2 = (Person[])oos2.readObject();//получим массив из файла и запишем его в нам массив делая из полученного объекта Downcasting - (Person[])
            System.out.println(Arrays.toString(people2));//выведем массив
            oos2.close();
        } catch (ClassNotFoundException e) {//на случай если такого класса нет по каким либо причинам. например запуск этого файла на другом устройстве
            throw new RuntimeException(e);
        }
    }
}
