package com.test.threading.synchronizators;
//CountDownLatch - это синхронизатор, позволяющий любому колличеству потоков ждать пока не завершится опред
// колличество операций. а конструктор CountDownLatch передается колличество операций который должны завершится
// чтобы потоки продолжили свою работу

import java.util.concurrent.CountDownLatch;

//у нас есть магазин в котором началась черная пятница. люди скопились у входа в магазин. но перед тем как купить что-то
//магазин должен:1 собрать персонал 2включить свет 3 4 5 итд. и в конце уже. открыться. с помощью CountDownLatch мы реализуем это
public class CountDownLatchEx {

    static CountDownLatch countDownLatch = new CountDownLatch(3);

    private static void marketPersonal() throws InterruptedException {//собрание персонала в магазине
        Thread.sleep(2000);
        System.out.println("Персонал собран");
        countDownLatch.countDown();//уменьшает колличество сделанных операций на один
        System.out.println("countDownLatch = " + countDownLatch.getCount());//выводим колличество необходимых операций перед открытием потока
    }
    private static void everythingIsReady() throws InterruptedException {//все готово, можно открывать магаин
        Thread.sleep(3000);
        System.out.println("Все открыто для открытия магазина");
        countDownLatch.countDown();//уменьшает колличество сделанных операций на один
        System.out.println("countDownLatch = " + countDownLatch.getCount());//выводим колличество необходимых операций перед открытием потока
    }
    private static void openMarket() throws InterruptedException {//открытие магазина
        Thread.sleep(4000);
        System.out.println("Магазин открыт");
        countDownLatch.countDown();//уменьшает колличество сделанных операций на один
        System.out.println("countDownLatch = " + countDownLatch.getCount());//выводим колличество необходимых операций перед открытием потока
    }

    public static void main(String[] args) throws InterruptedException {
        new People("Musa", countDownLatch);//создаем покупателей, и всем им передаем нас счетчик ожидания
        new People("Amina", countDownLatch);//открытия магазина
        new People("Hava", countDownLatch);
        new People("Mama", countDownLatch);
        new People("Papa", countDownLatch);

        marketPersonal();//выполянем все что надо для открытия магазина
        everythingIsReady();
        openMarket();
    }

}

class People extends Thread{
    String name;
    private CountDownLatch countDownLatch;
    public People(String name, CountDownLatch countDownLatch){
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start();
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();//блокирует тек поток, до того момента как счетчик countDownLatch не станет
            // равным 0, покупатели ждут открытие магазина. пока не соберется персонал итд
            System.out.println(name + " Приступил к закупке");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}