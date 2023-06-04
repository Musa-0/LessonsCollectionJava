package com.test.collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeEx {
    //Deque - наследуется от Queue и даёт возможность добавлять и использовать элементы и с начала очереди и с конца
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();//ArrayDeque наследуется от Deque и он является списком хронящим нашу двухстороннюю очередь
        deque.addFirst(1);//добавляет в начало
        deque.addLast(2);//добавляет в конец
        deque.offerFirst(4);
        deque.offerLast(3); // добавляют элементы, но если очередь переполнина то исключение об этом выбрасываться не будет
        deque.removeFirst();//удаляет в начале
        deque.removeLast();//удаляет с конца
        //deque.pollFirst(), deque.pollLast() - так же удаляет данные, но в случае если список пуст то ошибки не будет
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
        //deque.peekFirst(), deque.pollLast(); - берут данные из списка но если список пуст то не выводят ошибку
        System.out.println(deque);

    }
}
