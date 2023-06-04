package com.test.threading.data_race;
//Монитор - это специальный механизм благодаря которому достигается корректная работа при синхоронизации
//Каждый класс или объект имеет привязку к блоку памяти который называется монитор, монитор может иметь стату свободен/занят
//и если этот объект или класс, уже обрабатывается потоком, то статус будет занят, и другие потоки не смогут работать с этим
//объектом или классом. У метода нету монитора, этот монитор пренадлежит классу в котором лежит этот метод

//В этом коде будет synchronized block он в отличии от синхронизации метода, синхронизирует лишь часть кода а не весь метод
public class Synchronized_BlockEx {

    public static void main(String[] args) {
        MythreadIncrement2 runable = new MythreadIncrement2();
        Thread thread1 = new Thread(runable);
        Thread thread2 = new Thread(runable);
        Thread thread3 = new Thread(runable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
class Counter2{
    static volatile int count = 0;
    static volatile int statcount = 10;
    public static void statinct(){//это статический метод, а для синхронизации статических методов блокируют весь класс
        synchronized (Counter2.class){//блокируем весь класс на время для других потоков
            Counter2.statcount++;
            System.out.println(Counter2.statcount);
        }
    }
}

class MythreadIncrement2 implements Runnable{
    public void incr(){//synchronized метод - позволяет обрабатывать функцию лишь одному потоку
        synchronized (this) {//блокирует для других потоков объект с которым щас работает на время пока не завершится блок кода
            //вызывая монитор этого объекта this и тот меняет статус на "занят"
            Counter2.count++;//эта опирация как мы знаем не атомарна, её могут прервать в середине её выполнения
            System.out.println(Counter2.count);
        }
    }
    //НО прикол то в том, что ничего из этого не выйдет. переменную count должны увеличить каждый поток по три раза
    // и результат должен быть последовательным 1 2 3 4 5 6 7 8 9, но увы, пока один поток меняет эту переменную, другой уже её
    // поменял, а так как count++ не атомараня опирация, то и нет гарантий что один поток не прервет другой во время исполнения
    //ЧТОБЫ ЭТО ИСПРАВИТЬ ИСПОЛЬЗУЕМ метод synchronized и функцию increment сможет использовать лишь один поток

    @Override
    public void run() {
        for (int i = 0; i<3; i++){
            incr();//вызыввем функцию для увеличения count
            Counter2.statinct();//Вызываем статичный метод в классе Counter2
        }
    }
}
