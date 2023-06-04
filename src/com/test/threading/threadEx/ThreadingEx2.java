package com.test.threading.threadEx;

public class ThreadingEx2 {
    public static void main(String[] args) {
        MyThread2 thread = new MyThread2();
        thread.setName("one");
        MyThread2 thread3 = new MyThread2();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++) {
                    System.out.println("lol");
                }
            }
        });

        thread2.setPriority(2);//дает больший приоритет этому потоку
        thread.setPriority(1);//дает меньший приориитет этому потоку
        thread.start();
        thread2.start();
        thread3.start();
//        for (int i=0;i<100;i++){
//            System.out.println("lol");
//        }
        System.out.println("thread main end");
    }
}
class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i=0;i<100;i++) {

            if (i == 1) {
                Thread.yield();//если i=1 то программа передает работу другому потоку а сама переходит в режим ожидания пока её не вызовут снова
            }
            if(Thread.currentThread().getName().equals("one"))//getName берёт имя потока который мы сами можем задать
                System.out.println(i);
            else{
                System.out.println(i * (-1));
            }
        }
    }
}