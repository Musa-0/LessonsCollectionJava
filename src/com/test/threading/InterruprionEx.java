package com.test.threading;
//прерывание способно прервать поток

public class InterruprionEx {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main поток начался");
        InterruptedThread thread = new InterruptedThread();
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();//этот метод не прерывает поток, он лишь посылает сигнал из потока Main потоку thread что хочет прервать его
        //а если поток thread прочтет этот сигнал, то он может решить что ему делать, прерываться или нет, или мб перед прерыванием
        //он хочет что-то сделать, это все мы пропишем в нашем потоке
        thread.join();

        System.out.println("Main поток кончился");
    }
}

class InterruptedThread extends Thread{
    double sqrtSum=0;
    @Override
    public void run() {
        for (int i=1; i<=1000000000; i++){
            if(isInterrupted()){//он вернет True, если узнает что ему был послан сигнал на прерывание, и считав это, поток предпримет действия
                System.out.println("Поток хотят прервать");
                System.out.println("Все данные и объекты завершены, можно завершать поток");
                return;//таким образом завершаем работу потока
            }
            sqrtSum+=Math.sqrt(i);//прибавляем квадратный корень от этого числа
//            try { //А ТЫ РАЗБЛОКИРУЙ КОД ДА ПРОВЕРЬ
//                sleep(1000);
//            } catch (InterruptedException e) {
//                System.out.println("Поток хотят прервать во время сна");
//                System.out.println("Мы ничего завершать не будем, потому что не хочу");
//            } // если нас пытаются прервать во время сна то мы так же в исключении можем отреагировать на прерывание
        }
        System.out.println(sqrtSum);
    }
}
