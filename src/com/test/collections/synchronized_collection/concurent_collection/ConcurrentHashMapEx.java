package com.test.collections.synchronized_collection.concurent_collection;

import com.test.collections.HashMapEx;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

//Concurrent коллекции изначально были созданы для многопоточной работы. и они куда быстрее synchronized оберток
//ConcurrentHashMap - имплементирует интерфейс ConcurrentMap который в свою очередь происходит от интерфейса Мар
//он в отличии от synchronized не блокирует всю коллекцию. а лишь ту ячейчку с которой работает. и при этом два
//потока не могут обрабатывать один сигмент списка одновременно. в  ConcurrentHashMap ни ключ ни значение не могут быть null
public class ConcurrentHashMapEx {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();//Создадим ConcurrentHashMap и заполним его элементами
        map.put(1,"Musa");
        map.put(2,"Amina");
        map.put(3,"Hava");
        map.put(4,"Mama");
        map.put(5,"Papa");
        System.out.println(map);



        Runnable runnable1 = () -> {//выводит все элементы этого словаря
            Iterator<Integer> iterator = map.keySet().iterator();//берем все ключи из коллекции
            while (iterator.hasNext()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Integer i = iterator.next();
                System.out.println(i + ":" + map.get(i));//выводим ключ значение
            }
        };


        Runnable runnable2 = () ->{//поток на добавление нового элемента. в ConcurrentHashMap
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            map.put(6, "Elena");//добавит новый элемент. будь это просто ConcurrentHashMap была бы ошибка.
            // так как нельзя двум потокам работать одновременно с несинхронной коллекцией
        };
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();//заставляет поток main дождаться окончания потока thread1
        thread2.join();
        System.out.println(map);
    }
}
