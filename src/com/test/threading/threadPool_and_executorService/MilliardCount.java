package com.test.threading.threadPool_and_executorService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

//программа будет считать сумму всех чисел миллиарда, с помощью 10 потоков
public class MilliardCount {
    static long value = 1_000_000_000;
    static long sum = 0;
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Long>> listresfact = new ArrayList<>();
        long locvalue = value/10;//делим миллиард на 10 и получаем по частям который и будут считать потоки
        for (int i=0; i<10;i++){
            FactorialMilliard fact = new FactorialMilliard(locvalue*i, locvalue*(i+1));
            listresfact.add(executorService.submit(fact));//вызываем по функции для каждого 10-ого кусочка от миллиарда
            //и объект Future кладем в список, да да именно клдем, так как нам ещё не известен его результат а чтобы
            //узнать результат с помощью fact.get() надо ждать его окончания. а мы хотим вызвть все потоки чтобы все считали
            // а уже в конце будем складывать результаты каждого
        }
        for (Future<Long> f: listresfact){
            try {
                sum+=f.get();//в итоге складываем все эти результаты каждого кусочка.
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        executorService.shutdown();
        System.out.println(sum);
    }
}

class FactorialMilliard implements Callable<Long>{
    long from;
    long to;
    FactorialMilliard(long from, long to){//принимает начало отсчета и конец отсчета части от миллиарда
        this.from = from;
        this.to = to;
    }

    @Override
    public Long call() throws Exception {//вычисляет сумму всех чисел от from до to
        long localfact = 0;
        for (long i=this.from; i<=to;i++) {
            localfact += i;
        }
        return localfact;//возвращаем результат сложения чисел от from до to
    }
}
