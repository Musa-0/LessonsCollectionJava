package com.test.threading.threadPool_and_executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//Thread Pool - это объедененое множество потоков, в которое подаются разные задачи, и сам пул будет решать какое задание будет
//выполнять тот или иной поток, в зависимости от его свободности
//с пулами в java мы работаем с помощью объектов типа ExecutorService
public class ThreadPoolEx1 {
    public static void main(String[] args) throws InterruptedException {
        //ThreadPool удобнее всего создавать используя factory метода класса Executors,
        // factory - это уже готовое создание ThreadPoolExecutor, на прямую его лучше не создавать
        ExecutorService executorService = Executors.newFixedThreadPool(5);//создает пул с 5 потоками
       // ExecutorService executorService1 = Executors.newSingleThreadExecutor();// создает пул из одного потока
        for (int i=0;i<10; i++){
            executorService.execute(new RunnableImpl100());//передаем ему задание, вызывая какой-либо потом и увидем, что 5 потоков
            // берут на себя эту работу, и каждый поток получает работу если свободен, и того каждый поток отработает по 2 задачи
            //мы не создаем новые потоки, мы используем этот пул потоков, вызывая тот поток что сейчас свободен
        }
        executorService.shutdown();//при завершении всех задач, мы должны завершить наш пул, иначе его работа не кончится,
        // и программа не завершится, при этом текущие задачи будут обрабатываться потоками, но новый уже не поступит

        executorService.awaitTermination(2, TimeUnit.SECONDS);//этот метод, заставляет поток из которого он вызвался, ждать 5 секунд
        //или пока не завершится пул всех тех потоков у которых он и вызывает этот метод
        System.out.println("Main поток завершен");
    }
}

class RunnableImpl100 implements Runnable{

    @Override
    public void run() {
        System.out.println("Выполняется " + Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("закончился " + Thread.currentThread().getName());

    }
}