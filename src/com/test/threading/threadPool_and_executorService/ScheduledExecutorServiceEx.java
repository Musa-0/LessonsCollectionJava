package com.test.threading.threadPool_and_executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// ScheduledExecutorService - нужно для установки рассписания на запуск потоков пула
public class ScheduledExecutorServiceEx {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService =     //создаем пул потоков с рассписанием,
                Executors.newScheduledThreadPool(1);                   //из одного потока

        System.out.println("начало работы метода schedule");
        scheduledExecutorService.schedule(new RunnableImpl200(), 3, TimeUnit.SECONDS);//тут
            //мы создаем задачу для нашего пула, и говорим чтобы оно начало выполнятся через 3 секунды

        System.out.println("начало работы метода scheduleAtFixedRate");
        scheduledExecutorService.scheduleAtFixedRate(new RunnableImpl200(), 2,1,TimeUnit.SECONDS);
        //тут мы указываем сперва саму задачу, потом время через которое оно должно начаться а после,
        //указываем период, когда должно поступить новое точно такое же, короче говоря это будет выполняться
        //пока пул не завершится с помощью shutdown. если сам таск работает меньше чем время периода,
        //то после его окончания будет ждаться время до оставшееся от этой секунды, и уже начнется новое
        //короче задачи будут подаваться с периодичностью 1 секундой. если время работы потока больше 1 секунды
        //то тут он сперва закончит задачу а уже потом сразу начнет выполнять следующее. от начала первого таска
        // и до начала второго проходи время указанное в периоде то есть 1 сек
        Thread.sleep(10000);

        scheduledExecutorService.scheduleWithFixedDelay(new RunnableImpl200()
        , 3, 1, TimeUnit.SECONDS);//этот метод, отличается от scheduleAtFixedRate тем,
        //что тут проходит период после завершения пред таска, то есть, будет идти поток одинаковых
        // задач. и после завершения каждой задачи будет ждать опред колличество времни, и так будет
        //пока объект пула не завершится с помощью команды shutdown()

        scheduledExecutorService.shutdown();//завершаем работу пула, и ждем окончания работ его потоков

        ExecutorService executorService = Executors.newCachedThreadPool();//этот пул создает новые
        // потоки по мере необходимости
    }
}

class RunnableImpl200 implements Runnable{

    @Override
    public void run() {
        System.out.println("Выполняется " + Thread.currentThread().getName());
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("закончился " + Thread.currentThread().getName());

    }
}