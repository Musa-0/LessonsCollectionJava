package com.test.work_with_file.serializer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
//Таким образом мы молжем делать из объекта поток байт и отправлять его по интернету и клиент получит наш лобъект
public class WriteObject {
    //Записывает объекты в файл
    public static void main(String[] args){
        //Person person1 = new Person(1, "Musa");
        Person[] people = {new Person(3, "Fedor"),new Person(4, "Mike"),new Person(5, "LOL")};//массив объектов
        //запишем эти объекты в файл чтобы использовать их когда-нибудь. так все объекты в оперативной памяти будут удалены после оканчания работы программы. чтобы сохранить некоторые нужно их записать на жесткий диск
        //сериализуем эти объекты

        //1 способ записи массива объектов перебирая все объекты и по отдельности кладя в файл
        try {
            FileOutputStream fos = new FileOutputStream("src/com/test/work_with_file/serializer/person_object");//нужен для перевода из объекта в поток байт. он может записать что угодно. звук объект итд
            ObjectOutputStream oos = new ObjectOutputStream(fos);//нужен именно для записи объекта в файл. он берёт наши объекты и делает из них поток байтов а после передаёт нашему FileOutputStream и тот их уже записывает в файл
            //oos.writeObject(person1);//запишем наш объект в файл
            oos.writeInt(people.length);//запишем колличество объектов в файл чтобы когда мы могли прочитать эти объекты цикл for знал сколько раз надо достать элементы
            for(Person p:people) {
            oos.writeObject(p);//запишем все объекты в файл
            }

            oos.close();
        } catch (IOException e) {// нам не нужно прописывать Filenotfoundexception так как IOException включает в себя это исключение
            throw new RuntimeException(e);
        }

        //2 способ. массив это тоже объект и мы можем просто передать массив с объектами как есть
        try( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/com/test/work_with_file/serializer/person_object2"))) {//Создаём внутри try наш объект записи и в конце try он будет сам закрываться
            oos.writeObject(people);//запишем нам массив в файл

        } catch (IOException e) {// нам н ееужно прописывать Filenotfoundexception так как IOException включает в себя это исключение
            throw new RuntimeException(e);
        }
    }
}
