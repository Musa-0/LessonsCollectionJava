package com.test.threading.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//у нас есть банкомат которым может пользоваться лишь один человек
public class Bankomat {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Employee("Musa", lock);//создаем пользователей банкоматов, и в конструкторе они автоматически запускаются
        new Employee("Hava", lock);
        new Employee("Amina", lock);
        new Employee("Misha", lock);

    }
}
class Employee extends Thread{
    String name;
    private Lock lock;

    public Employee(String name, Lock lock) {
        this.name = name;
        this.lock = lock;//присваеваем общую переменную блокировки для блокировки всех пользователей банкомата когда он занят
        this.start();//СРАЗУ ЗАПУСТИМ НАШ ПОТОК ПРИ СОЗДАНИИ
    }

    @Override
    public void run() {
            try {
                System.out.println(name + " ждет...");
                lock.lock();
                System.out.println(name + " пользуется банкоматом");
                Thread.sleep(2000);
                System.out.println(name + " завершил свои дела");
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();//пишем освобождение обязательно в finaly так как если будет исключение то lock не освободиться
            }
    }
}
//есть ещё метод tryLock - lock.tryLock() - он войдет в блок кода, и будет его выполнять если тот свободен, если нет,
// то он просто пойдет дальше. все равно что пошел в магазин, увидел что есть очередь и от не желания ждать ушел от туда.
//ничего не купив