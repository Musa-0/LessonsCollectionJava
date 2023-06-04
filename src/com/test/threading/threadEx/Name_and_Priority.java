package com.test.threading.threadEx;

public class Name_and_Priority {
    public static void main(String[] args) {
        Mythread3 thread3 = new Mythread3();
        System.out.println(thread3.getName());// под дефолту имя потока Thread-0 - номер потока по вызову
        System.out.println(thread3.getPriority());// под дефолту приоритет потока 5

        Mythread3 thread3_1 = new Mythread3();
        thread3_1.setName("Musa_Thread");//даем имя
        thread3_1.setPriority(9);//даем приоритет 9 максимальный 10;
        System.out.println(thread3_1.getName());// под дефолту имя потока Thread-0 - номер потока по вызову
        System.out.println(thread3_1.getPriority());// под дефолту приоритет потока 5
        thread3_1.start();
    }


}

class Mythread3 extends Thread{
    @Override
    public void run() {
        Thread.currentThread().getName();//currentThread берет поток в котором мы сейчас находимся
        System.out.println("Привет");
    }
}