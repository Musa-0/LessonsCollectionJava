package com.test.collections;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListQueue {
    //Oueue - это базовый интерфейс который хранит последовательнось элементов для какой-либо обработки
    //LinkedList помимо наследования его от List, ещё наследуется и от Deque(а тот наследуется от Queue) и работает как очередь
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Musa");
        queue.offer("Hava");//добавлене
        queue.add("Amina");
        System.out.println(queue.remove());//удаляет первый элемент в очереди так как таковы правила очереди. кто первый пришел тот первый ушел
        System.out.println(queue.element());//возвращает первого человека в очереди. если очередь будет пуста то будет ошибка. peek() работает так же он если будет пуст список, то ошибки не будет
        System.out.println(queue);
        System.out.println(queue.remove("Amina"));//удаляет по значению
        System.out.println(queue.poll());//удаляет первый элемент но если в очереди уже никого не будет то ошибки не будет он лишь вернет null в отличии от remove
        //add добавляет элемент в очередь, но если мест уже нет то оно выбрасовает исключение, а offer так же добавляет но в случае переполненич не выбрасывает исключение
        System.out.println(queue);//будет выведено по очереди. сначала Муса и в конце Амина
    }
}
