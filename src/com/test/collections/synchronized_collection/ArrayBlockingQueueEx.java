package com.test.collections.synchronized_collection;

import java.util.concurrent.ArrayBlockingQueue;

//ArrayBlockingQueue - имплеентирует Queue, но при этом работает с многопоточностью. и имеет ограниченый размер
//Создадим очередь. в которой будет Producer который отправляет элементы каждую 1 секунду в конец очереди. и Consumer
//который будет брать это значение из начала очереди каждый 3 секунды. такими темпами очередь переполнится.
// и Producer не будет ничего добавлять пока Consumer ничего не заберет из очереди.

public class ArrayBlockingQueueEx {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);//создаем ArrayBlockingQueue с 4 местами
    //Producer
        new Thread(() -> {
            int i =0;
            while (true){
                try {
                    queue.put(++i);//кладем в очередь элемент с помощью метода put
                    System.out.println("Producer добавил: " + i + " -> " + queue);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();//создаем поток и сразу его запускаем

    //Consumer
        new Thread(() -> {
            while (true){
                try {
                    Integer j =queue.take();//берем элемент из очереди с помощью метода take
                    System.out.println("Consumer забрал : " + j + " -> " + queue);
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();//создаем поток и сразу его запускаем
    }


}









