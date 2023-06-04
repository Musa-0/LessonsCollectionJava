package com.test.threading;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomar {
    //атомарные операции это операции которые выполняются не прирывно
    static int i;
    //сделаем атомарную переменную, менять которую надо не прирывно
    static AtomicInteger a = new AtomicInteger(0);//атомарная переменная, менять её можно лишь через методы класса AtomicInteger присвоим ей 0
    public static void main(String[] args) throws InterruptedException {
        for(int j=0;j<10000;j++){//i должно 10000 раз увеличиться на 1, но оно не увеличится 10000 раз, так как операция инкримента не атомарная и одну опирацию увеличения может прервать другой поток
            new Mythread5().start();
        }
        Thread.sleep(2000);
        System.out.println(i);//тут не будет 10000
        System.out.println(a.get());//а тут будет
    }
    static class Mythread5 extends Thread{
        @Override
        public void run() {
            //как происходит инкремент на самомо деле
            i++;//это выражение не атомарно,(не выполняется в одно действие не прирывно) под капотом делает
            //int k = i+1;
            //i=k;

            //но что если поток прервется на середине и предаст выполнение другому потоку
            //thread1
            //int k=i+1;
            //thread2
            //int k = i+1;
            //i=k;
            //thread1
            //i=k
            //в таком случае i увеличится на 1 всего один раз

            a.incrementAndGet();//а тут мы делаем атомарную опирацию по увеличению на единицу a++
            //a.getAndIncrement();// это ++a
            //a.addAndGet(5);//прибавляем по пять
        }
    }
}
