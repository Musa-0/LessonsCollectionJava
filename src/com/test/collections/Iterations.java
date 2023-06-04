package com.test.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class Iterations {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("lol1");
        arrayList.add("lol2");
        arrayList.add("lol3");
        Iterator<String> iterator = arrayList.iterator();//делает гениратор
        while (iterator.hasNext()){//если есть ещё объект то
            System.out.println(iterator.next());


        }
    }
}
