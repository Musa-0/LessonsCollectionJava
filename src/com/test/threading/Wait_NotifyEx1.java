package com.test.threading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//у нас есть машина в которую вводят данные которые она должна печатать.пока повых данных нет она должна ожидать, и с каждымы новыми данными будет приходить уведомление что пора печатать
public class Wait_NotifyEx1 {
    static List<String> strings = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws InterruptedException {
        new Operator().start();
        new Machine().start();
    }
    static class Operator extends Thread{
        @Override
        public void run() {
            Scanner sc = new Scanner(System.in);
            while (true){
                strings.add(sc.nextLine());//добавляем новую напечатанную строку в наш список

                synchronized (strings){//синхронно работаем с нашим списком
                    strings.notify();//и сообщаем второму классу о том что можно печатать и продолжает работу пока не наткнется на wait
                    try {
                        strings.wait();//и после ждет пока тот напечатает
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
    static class Machine extends Thread{
        @Override
        public void run() {
            while (strings.isEmpty()){//если список не пуст то не смотрим его, это сделали мы специально чтобы он читал только в случае notify с места где у нас wait()
                synchronized (strings) {//работает синхронно
                    try {
                        strings.wait();//после того как напечатали, ждет пока не прийдет уведомление о новом сообщении который надо печатать
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }


                        System.out.println(strings.remove(0));//выводит и удаляет первый элемент

                    strings.notify();//после того как он напечатал он позволяет дальше печатать
                }
            }
        }
    }
}