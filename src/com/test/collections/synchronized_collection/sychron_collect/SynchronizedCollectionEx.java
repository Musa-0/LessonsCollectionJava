package com.test.collections.synchronized_collection.sychron_collect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedCollectionEx {
    //SynchronizedCollection это обычные коллекции которые делают многопоточными с помощью обертывания
    //например есть ArrayList если его сделать синхронным то каждый поток будет вставать в очередь перед тем как
    // сделать какую-то операцию со списком, это не быстрая работа. Он лишь создает у коллекции lock и дает обрабатывать лишь одному. и это очень медленно
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> source = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            source.add(i);
        }
        ArrayList<Integer> target = new ArrayList<>();
        Runnable runnable = () -> {
            target.addAll(source);
        };// определяет действие для потока
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();//заставляет поток main дождаться окончания потока thread1
        thread2.join();
        System.out.println(target);//В СЛУЧАЕ ЕСЛИ У НАС БУДЕТ ПРОСТОЙ СПИСОК ДАННЫЕ В НЕГО БУДУТ ДОБАВЛЯТЬСЯ
        // КАК ПОПАЛО второй поток может вообще не сработать, А НАМ НАДО СИНХРОННОЕ ДОБАВЛЕНИЕ ИСПОЛЬЗУЕМ СИНХРОННЫЙ СПИСОК
        List<Integer> synchList = Collections.synchronizedList(new ArrayList<>());
        Runnable syncrunnable = () -> {
            synchList.addAll(source);
        };
        Thread syncthread1 = new Thread(syncrunnable);
        Thread syncthread2 = new Thread(syncrunnable);
        syncthread1.start();
        syncthread2.start();
        syncthread1.join();//заставляет поток main дождаться окончания потока thread1
        syncthread2.join();
        System.out.println(synchList);//в этом случае второй поток выполнит операцию тогда когда закончит первый
        //если мы имеем дело с такими коллекциями то функции которые обрабатывают эти коллекции должны быть synchronized
        // так как если они будут не атомарные то в одну функцию может влезть другая и будет путаница и ошибки
    }
}
