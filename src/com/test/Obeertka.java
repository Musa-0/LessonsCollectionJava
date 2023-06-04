package com.test;

public class Obeertka {
    public static void main(String[] args) {
        int a = 1;
        //если нам нужно просто число то используй примитивы а есл инам нужен какой-то метод от него то используй классы обертки
        Integer b = new Integer(2);//это встроенный класс - обёртка который реализует int и имеет методы
        Integer m = 12;
        int d = Integer.parseInt("22");
    }
}//Double Float Long String Integer Short Byte Character Boolean
