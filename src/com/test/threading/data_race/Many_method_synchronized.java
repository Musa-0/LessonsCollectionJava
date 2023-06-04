package com.test.threading.data_race;
//Допутим у нас есть телефон на который звонят по мобильной связи по скайпу whatsup, и надо сделать так чтобы отвечать
//мы могли лишь на  один звонок, тупо заблокировав остальным потокам канал на подключение
//КОНСТРУКТОРЫ класса изначально синхроны то есть их может обрабатывать лишь один поток
public class Many_method_synchronized {
    static final Object call = new Object();//эта переменная, будет служить объектом, по которому будут блакироваться все методы
    //сразу, так чтобы мог работать лишь один поток обычно его называют lock но я сделал call
    void mobileCall() {//звонок по мобильной связи
        synchronized (call) {
            System.out.println("Мобильная связь началась!");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Мобильная связь закончилась!");
        }
    }

    void skypeCall() {//звонок по скайпу
        synchronized (call) {

            System.out.println("Skype связь началась!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Skype связь закончилась!");
    }}

    void whatsuppCall() {//звонок по whatsupp
        synchronized (call) {

            System.out.println("Whatsupp связь началась!");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Whatsupp связь закончилась!");
    }}

    public static void main(String[] args) {
        Thread threadmob = new Thread(new RunnableImpMobile1());//создаем потоки звонков
        Thread threadskype = new Thread(new RunnableImpSkype1());
        Thread threadwhatsupp = new Thread(new RunnableImpWhatsupp1());

        threadmob.start();
        threadskype.start();
        threadwhatsupp.start();
    }

}

class RunnableImpMobile1 implements Runnable{//для звонка по мобильной связи

    @Override
    public void run() {
            new Many_method_synchronized().mobileCall();

    }
}

class RunnableImpSkype1 implements Runnable{//для связи по скайпу

    @Override
    public void run() {
        new Many_method_synchronized().skypeCall();

    }
}

class RunnableImpWhatsupp1 implements Runnable{//для связи по вотсапу

    @Override
    public void run() {
        new Many_method_synchronized().whatsuppCall();

    }
}

