package com.test.threading.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockEx {
    public static void main(String[] args) throws InterruptedException {


        Resorce1 resorce = new Resorce1();
        resorce.i = 5;
        MyThread7 thread = new MyThread7();
        MyThread7 thread2 = new MyThread7();
        thread.setResorce(resorce);
        thread2.setResorce(resorce);
        thread2.start();
        thread.start();
        thread.join();
        thread2.join();
        System.out.println(resorce.i);
    }
}

class MyThread7 extends Thread{
    Resorce1 resorce;
    public void setResorce(Resorce1 resorce){//теперь все будет синхронно
        this.resorce = resorce;
    }
    @Override
    public void run() {
        resorce.change();
        resorce.change2();
    }
}
class Resorce1{//класс ресурса к которому будут обращаться потоки
    int i;
    //нам надо сделать так чтобы два или более метода выполнялись не прерывно, synchronized тут не поможет. можно исп Lock.ReentranLook
    Lock lock = new ReentrantLock();
    public void change(){
        lock.lock();//с этого момента функцию может выполнять лишь один поток
        int i = this.i;
        i++;
        this.i=i;
    }
    public void change2(){
        int i = this.i;
        i++;
        this.i=i;
        lock.unlock();//конец синхронной функции
    }
}

