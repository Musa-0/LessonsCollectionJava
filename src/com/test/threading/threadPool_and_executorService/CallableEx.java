package com.test.threading.threadPool_and_executorService;
//Callsble как и Runnable представляет собой опред задание выполняемое потоком, но в отличии от Runnable Callable
//1 имеет return тип не void, то есть может что-то возвращать
//2 может выбрасывать Exeption
//метод submit передает наше задание в thread pool для выполнения одним из потоков и возвразает тип Future а котором
//и хранится результат выполнения нашего задания
//Callable можно создавать лишь для Executors то есть пулов, через new Thread нельзя
import java.util.concurrent.*;

public class CallableEx {
    static int factorialResult;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();//создаем пул с одним потоком
        Factorial factorial = new Factorial(5);
        Future<Integer> future = executorService.submit(factorial);//submit как и execute помещает наш таск в пул
        // но при этом ещё и возвращает результат присваивая это объекту Future, а уже из него мы берем наш результат
        //Future это тип создающий объект ожидающий результат в будущем, и ему будет присвоено значение результата
        //потока после его окончания
        try {
            System.out.println(future.isDone());//проверяет, вернул ли поток результат переменной future

            factorialResult = future.get();//метод get прервет текущий поток, если поток для futer ещё не завершен
            // и не вернул результат. текущий поток, ожидает завершения потока future, чтобы получить результат для
            // fact и продолжить работу
        } catch (InterruptedException e) {//на случай если нас собьет прерывание при ожидании результата задания потока
            throw new RuntimeException(e);
        } catch (ExecutionException e) {//в случае если поток выдаст исключение
            System.out.println(e.getCause());//выведет то что должно было выведеться в блоке из которого он вызвался тот что в классе Factorial
        }
        finally {
            executorService.shutdown();//в итоге если блок завершится успешно то закрываем наш пул
        }
        System.out.println(factorialResult);
    }
}


class Factorial implements Callable<Integer>{//этот поток вернет в итоге int значение факториала числа
    int f;

    public Factorial(int f){
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {//это как метод run, вызывает поток
        if (f<=0){
            throw new Exception("Вы ввели не коректное число");//в Callable мы можем выбрасить исключение и поток завершится
        }

        int res = 1;
        for (int i=1;i<=f;i++){
            res *=i;
            Thread.sleep(300);
        }
        return res;
    }

}