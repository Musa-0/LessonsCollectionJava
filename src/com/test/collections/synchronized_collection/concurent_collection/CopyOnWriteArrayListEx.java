package com.test.collections.synchronized_collection.concurent_collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

//CopyOnWriteArrayList - имплиментирует List. его слудует использовать для работы с несколькими потоками. и при этом
//у нас небольшое колличество операций по изменению(добавление удаленик) элементов и большое колличество по их чтению
//CopyOnWriteArrayList при любом изменении листа, создается клон копии листа с изменениями
public class CopyOnWriteArrayListEx {
    public static void main(String[] args) throws InterruptedException {

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();//создаем CopyOnWriteArrayList и наполняем его
        list.add("Musa1");
        list.add("Musa2");
        list.add("Musa3");
        list.add("Musa4");
        list.add("Musa5");
        System.out.println(list);


        Runnable runnable1 = () -> {//читаем все элементы листа
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(iterator.next());//что бы мы не делали с этим листом в других потоках, этот лист не изменится
                //ибо в других местех создалась копия этого листа. и он никак не обращает знимание на изменения в листе в других потоках
            }
        };


        Runnable runnable2 = () -> {//удаляем и добавляем элементы в лист
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list.remove(4);// Создается копия листа. в которой производятся изменения. и для след потоков
            list.add("Musa6");// это и будет актуальный лист. и в него же мы и добавляем Musa6 и удаляем 4 элемент

        };


        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(list);
    }
}

//так же есть CopyOnWriteArraySet это тоже самое но Set