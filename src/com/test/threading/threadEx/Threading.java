package com.test.threading.threadEx;

public class Threading {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();//ЭТОТ МЕТОД ВЫЗЫВАЕТ МЕТОД run В МНОГОПОТОЧНОМ ФОРМАТЕ
        MyThread thread2 = new MyThread();
        thread2.start();

        Thread thread3 = new Thread(new Runner());
        thread3.start();
        System.out.println(thread.getState());//выводит состояние потока NEW-создан и не запещен RUNNABLE-запущен TERMINATED-закончен
        //поток main завершился но сама программа завершится когда завершатся все потоки
        thread.join();//поток main ждет завершения потока thread перед тем как продолжить код
        thread2.join(2000);//поток main или ждет 2 секунды, или ждет завершение потока thread2 если тот закончился раньше чем за 2 секунды
        System.out.println("End");
    }
}
//1 способ создания потока
class MyThread extends Thread{//этот класс при вызове его методов будет исполняться в своём потоке параллельно основному потоку
public void run(){//переопределим метод для исполнения кода в отдельном потоке
    for (int i =0; i<100;i++) {
        try {
            Thread.sleep(1000);//засыпание на секунду поток не используется 1 секунду, он отдает возможность другим работать

        } catch (InterruptedException e) {//это исключение срабатывает тогда когда поток делает прерывание
            System.out.println("Property");
        }
        System.out.println(i);
    }

}
}
//2 способ создания потока
class Runner implements Runnable{//интерфейс который позволит на прямую переопределить метод run

    @Override
    public void run() {
        for (int i =0; i<100;i++) {
            try {
                Thread.sleep(1000);//засыпание на 1 секунды

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }
    }
}
