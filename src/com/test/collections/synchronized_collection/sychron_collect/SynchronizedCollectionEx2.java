package com.test.collections.synchronized_collection.sychron_collect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SynchronizedCollectionEx2 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList list = new ArrayList();
        for(int i = 0; i<100;i++){
            list.add(i);
        }
        List<Integer> sync = Collections.synchronizedList(list);//создаем синхронный список
        Runnable runnable1 = () -> {
            synchronized (sync){//ВО ВРЕМЯ ИТЕРАЦИИ СПИСКА НЕЛЬЗЯ ЕГО КАК-ТО МЕНТЬ И ЭТА ФУНКЦИЯ НЕ ДАЁТ ДРУГИМ
                // ПОТОКАМ ЧТО-ТО ДЕЛАТЬ СО СПИСКОМ ПОКА НЕ ПРОШЛА ПОЛНАЯ ИТЕРАЦИЯ а объект которым пользуются
                // несколько потоков это список который мы и передаем
            Iterator<Integer> iterator = sync.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }}
        };
        Runnable runnable2 = () -> {sync.remove(10);};// удалит десятый элемент
    Thread thread1 = new Thread(runnable1);
    Thread thread2 = new Thread(runnable2);
    thread1.start();
    thread2.start();
    thread1.join();
    thread2.join();
    System.out.println(sync);
    //коллекции с обертыванием не надежны, так как функции которые их обрабатывают должны быть атомарными
        // (выполняться не прирывно) иначе во врем выполнения удаления может начаться чтение, и тогда он прочтет
        // то что должно было удалиться, и индексы не успели сместиться, так как первый ещё не удален, так что все
        // операции с такими коллекциями должны быть synchronized
    }
}