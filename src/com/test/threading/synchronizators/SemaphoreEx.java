package com.test.threading.synchronizators;

import java.util.concurrent.Semaphore;

//Semaphore - синхронизатор позволяющий ограничить доступ к какому-то ресурсу, в конструктор Semaphore нужно передавать
//колличество потоков, которым Semaphore будет разрешать одновременно использовать этот ресурс

//программа телефонная будка где всего два места
public class SemaphoreEx {
    public static void main(String[] args) {
        Semaphore callbox = new Semaphore(2);//указываем колличество одновременно работающих потоков

        new Person("Musa", callbox);//лишь двоя смогут использовать телефон одновременноостальные будут ждать
        new Person("Amina", callbox);
        new Person("Hava", callbox);
        new Person("Loool", callbox);
        new Person("Ana", callbox);

    }
}


class Person extends Thread{
    String name;
    private Semaphore callBox;

    public Person(String name, Semaphore callBox){
        this.name = name;
        this.callBox = callBox;
        this.start();//Сделаем чтобы объект потока сразу запускался
    }

    @Override
    public void run() {

        try {
            System.out.println(name + " ждет...");
            callBox.acquire();//этот метод,предназначен для попытки получить разрешение у Semaphore, он заблокирует
            //текущий поток, пока не получит доступ к ресурсу
            System.out.println(name + " пользуется телефоном");
            sleep(2000);
            System.out.println(name + " завершил звонок");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            callBox.release();//если все успешно, то говорим Semaphore о том что ресурс больше не нужен потоку,
            // и что кто-то другой может попользоваться им
        }
    }
}