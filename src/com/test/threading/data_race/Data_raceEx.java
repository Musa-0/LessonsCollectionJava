package com.test.threading.data_race;
//Data_race - это гонка процессоров за время работы этого самого процессора
public class Data_raceEx {


    public static void main(String[] args) {
        MythreadIncrement runable = new MythreadIncrement();
        Thread thread1 = new Thread(runable);
        Thread thread2 = new Thread(runable);
        Thread thread3 = new Thread(runable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
class Counter{
    static volatile int count = 0;
}

class MythreadIncrement implements Runnable{
    public static synchronized void  increment(){//synchronized метод - позволяет обрабатывать функцию лишь одному потоку

        Counter.count++;//эта опирация как мы знаем не атомарна, её могут прервать в середине её выполнения
        System.out.print(Counter.count + " ");

    }
    //НО прикол то в том, что ничего из этого не выйдет. переменную count должны увеличить каждый поток по три раза
    // и результат должен быть последовательным 1 2 3 4 5 6 7 8 9, но увы, пока один поток меняет эту переменную, другой уже её
    // поменял, а так как count++ не атомараня опирация, то и нет гарантий что один поток не прервет другой во время исполнения
    //ЧТОБЫ ЭТО ИСПРАВИТЬ ИСПОЛЬЗУЕМ метод synchronized и функцию increment сможет использовать лишь один поток

    @Override
    public void run() {
        for (int i = 0; i<3; i++){
            increment();//вызыввем функцию для увеличения count
        }
    }
}