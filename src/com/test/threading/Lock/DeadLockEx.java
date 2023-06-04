package com.test.threading.Lock;

public class DeadLockEx {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread3 thread3 = new Thread3();
        Thread4 thread4 = new Thread4();
        thread3.start();
        thread4.start();
    }
}

class Thread3 extends Thread{
    @Override
    public void run() {
        System.out.println("Thread3 попытка захватить монитор lock1");
        synchronized (DeadLockEx.lock1){//захватывает lock1
            System.out.println("Монитор объета lock1 захвачен");

            System.out.println("Thread3 попытка захватить монитор lock2");
            synchronized (DeadLockEx.lock2){//пыается захватить lock2 но он уже захвачен, Thread4 который ждет завершения lock1
                System.out.println("Монитор объетов lock1 и lock2 захвачены");//но увы lock один тоже захвачин Thread3

            }
    }
}
}
class Thread4 extends Thread{
    @Override
    public void run() {
        System.out.println("Thread4 попытка захватить монитор lock2");
        synchronized (DeadLockEx.lock2){//захватывает lock2. во избежании deadlock надо заменить на lock1
            System.out.println("Монитор объета lock2 захвачен");

            System.out.println("Thread4 попытка захватить монитор lock1");
            synchronized (DeadLockEx.lock1){//пытается захватить lock1 но он уже захвачен,во избежании deadlock надо заменить на lock2
                System.out.println("Монитор объетов lock1 и lock2 захвачены");

            }
        }
    }
//это ситуация называется Deadlock мертвая блокировка, когда два потока взаимо блокируют друг друга, и из этого уже не вылезти
//дабы подобного избежать, сделайте так чтобы локи захватывали одновременно и не были зависимы друг от друга

    // есть так же Lock Live это когда одновременно что-то сделали, например как машины на мосту, одновременно увидели друг друга
    //так же есть Lock starvation это когда более приоритетные потоки не дают работать менее приоритетным,
}
